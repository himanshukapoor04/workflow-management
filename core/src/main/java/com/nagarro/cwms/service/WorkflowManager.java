package com.nagarro.cwms.service;

import java.util.List;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;

@Local
public interface WorkflowManager {
	
	void startWorkflowInstance(WorkflowDefinition workflowDefinition);
	
	WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition);
	
	List<WorkflowDefinition> getAllWorkflowDefinition();
	
	WorkflowDefinition getWorkflowDefinitionById(Long id);
}
