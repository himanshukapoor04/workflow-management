package com.nagarro.cwms.service;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;

@Local
public interface WorkflowManager {
	
	WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition);
	
	WorkflowDefinition getWorkflowDefinition();
}
