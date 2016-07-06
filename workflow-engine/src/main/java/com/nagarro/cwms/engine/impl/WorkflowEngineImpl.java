package com.nagarro.cwms.engine.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.cache.StepInstanceCache;
import com.nagarro.cwms.cache.WorkflowInstanceCache;
import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.engine.StepExecutionServiceFactory;
import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

@Stateless
public class WorkflowEngineImpl implements WorkflowEngine {

	@EJB
	private WorkflowManager workflowManager;

	@EJB
	private StepExecutionServiceFactory stepExecutionServiceFactory;

	public void execute(WorkflowMessage message) throws CWMSException {
		// TODO Workflows as of now are handled based on workdlow id only but
		// we have to handle instance id as well
		if (message == null) {
			throw new CWMSServiceException("Workflow is invalid");
		}
		WorkflowInstance workflowInstance = null;
		try {
			WorkflowDefinition workflowDefinition = workflowManager
					.getWorkflowDefinitionById(message.getWorkflowId());
			if(message.getWorkflowInstanceId() != null) {
				workflowInstance = WorkflowInstanceCache.getInstance().getInstanceStateHealth(message.getWorkflowId(), message.getWorkflowInstanceId());
			} else {
				workflowInstance = workflowManager
					.createWorkflowInstance(workflowDefinition);
				WorkflowInstanceCache.getInstance().put(
						workflowInstance.getWorkflow().getId(),
						workflowInstance.getId(), workflowInstance);
			}
			if(message.getStepInstanceId() != null) {
				StepInstanceCache.getInstance().get(message.getStepInstanceId()).setStepState(InstanceState.FINISHED);
			}
			NextState nextState = null;
			if (workflowInstance.getWorkflow().getSteps() != null
					&& !workflowInstance.getWorkflow().getSteps().isEmpty()) {
				for (Step step : workflowInstance.getWorkflow().getSteps()) {
					if(workflowInstance.getExecutedStep() == null || ( workflowInstance.getExecutedStep() != null &&!workflowInstance.getExecutedStep().contains(step))) {
						StepExecutionService stepExecutionService = stepExecutionServiceFactory
								.getStepExecutionService(step);
						ExecutionContext executionContext = new ExecutionContext();
						if(workflowInstance.getExecutedStep() != null) {
							workflowInstance.getExecutedStep().add(step);
						} else {
							List<Step> executedStep = new ArrayList<Step>();
							executedStep.add(step);
							workflowInstance.setExecutedStep(executedStep);
						}
						
						nextState = stepExecutionService.executeStep(executionContext, step,
								workflowInstance);
						if(nextState== NextState.BLOCKED) {
							break;
						}
					}
				}
			}
			System.out.println("Next State is "+nextState);
			if(nextState != null && NextState.RUN == nextState) {
				System.out.println("Setting finish");
				workflowInstance.setWorkflowState(InstanceState.FINISHED); 
			} else {
				System.out.println("Setting blocked");
				workflowInstance.setWorkflowState(InstanceState.BLOCKED);
			}
		} catch (Exception exception) {
			if (workflowInstance != null) {
				workflowInstance.setWorkflowState(InstanceState.BLOCKED);
			}
			exception.printStackTrace();
		}
		if (workflowInstance != null) {
			WorkflowInstanceCache.getInstance().put(
					workflowInstance.getWorkflow().getId(),
					workflowInstance.getId(), workflowInstance);
		}

	}

}
