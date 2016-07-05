package com.nagarro.cwms.engine.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.cache.WorkflowInstanceCache;
import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.engine.StepExecutionServiceFactory;
import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.InstanceState;
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
			workflowInstance = workflowManager
					.createWorkflowInstance(workflowDefinition);
			WorkflowInstanceCache.getInstance().put(
					workflowInstance.getWorkflow().getId(),
					workflowInstance.getId(),
					workflowInstance.getWorkflowState());
			if (workflowInstance.getWorkflow().getSteps() != null
					&& !workflowInstance.getWorkflow().getSteps().isEmpty()) {
				for (Step step : workflowInstance.getWorkflow().getSteps()) {
					StepExecutionService stepExecutionService = stepExecutionServiceFactory
							.getStepExecutionService(step);
					ExecutionContext executionContext = new ExecutionContext();
					stepExecutionService.executeStep(executionContext, step,
							workflowInstance);
				}
			}
			workflowInstance.setWorkflowState(InstanceState.FINISHED);
		} catch (Exception exception) {
			if (workflowInstance != null) {
				workflowInstance.setWorkflowState(InstanceState.BLOCKED);
			}
			exception.printStackTrace();
		}
		if (workflowInstance != null) {
			WorkflowInstanceCache.getInstance().put(
					workflowInstance.getWorkflow().getId(),
					workflowInstance.getId(),
					workflowInstance.getWorkflowState());
		}

	}

}
