package com.nagarro.cwms.engine.impl;

import javax.ejb.EJB;

import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

@EJB
public class WorkflowEngineImpl implements WorkflowEngine {
	
	@EJB
	WorkflowManager workflowManager;
	
	public void execute(WorkflowMessage message) throws CWMSException {
		// TODO Workflows as of now are handled based on workdlow id only but
		// we have to handle instance id as well
		if(message == null ) {
			throw new CWMSServiceException("Workflow is invalid");
		}
		
		WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinition();
		workflowManager.createWorkflowInstance(workflowDefinition);

	}

}
