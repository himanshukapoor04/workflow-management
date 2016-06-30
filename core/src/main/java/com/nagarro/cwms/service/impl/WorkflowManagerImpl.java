package com.nagarro.cwms.service.impl;

import javax.ejb.EJB;

import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

@EJB
public class WorkflowManagerImpl implements WorkflowManager {

	public WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition) {
		return new WorkflowInstance(workflowDefinition);
	}

	public WorkflowDefinition getWorkflowDefinition() {
		return new WorkflowDefinition();
	}

}
