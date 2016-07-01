package com.nagarro.cwms.engine.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.engine.StepExecutionServiceFactory;
import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
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
		if(message == null ) {
			throw new CWMSServiceException("Workflow is invalid");
		}
		
		WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinition();
		WorkflowInstance workflowInstance = workflowManager.createWorkflowInstance(workflowDefinition);
		if(workflowInstance.getWorkflow().getSteps() != null && !workflowInstance.getWorkflow().getSteps().isEmpty()) {
			for(Step step : workflowInstance.getWorkflow().getSteps()) {
				StepExecutionService stepExecutionService = stepExecutionServiceFactory.getStepExecutionService(step);
				stepExecutionService.executeStep(null, step, workflowInstance);
			}
		}

	}

}
