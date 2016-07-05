package com.nagarro.cwms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.helper.WorkflowManagerHelper;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;
import com.nagarro.cwms.service.WorkflowMessageSender;

@Stateless(mappedName="ejb/WorkflowManager")
public class WorkflowManagerImpl implements WorkflowManager {

	@EJB
	WorkflowMessageSender messageSender;
	
	public void startWorkflowInstance(WorkflowDefinition workflowDefinition) {
		WorkflowMessage workflowMessage = new WorkflowMessage(workflowDefinition.getId());
		messageSender.sendMessage(workflowMessage);
	}
	
	public WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition) {
		WorkflowInstance workflowInstance = new WorkflowInstance(workflowDefinition);
		return workflowInstance;
	}

	public List<WorkflowDefinition> getAllWorkflowDefinition() {
		/* Returning hard coded data would be replaced by Cache look up and DB look up if not found in cache. */
		List<WorkflowDefinition> workflowDefinitions = new ArrayList<WorkflowDefinition>();
		WorkflowDefinition workflowDefinition = new WorkflowDefinition(new Long(1), "Sample Workflow Definition", "Sample Workflow Definition");
		workflowDefinition.setSteps(WorkflowManagerHelper.getSteps());
		workflowDefinitions.add(workflowDefinition);
		return workflowDefinitions;
	}
	
	public WorkflowDefinition getWorkflowDefinitionById(Long id) {
		/* Returning hard coded data would be replaced by Cache look up and DB look up if not found in cache. */
		WorkflowDefinition workflowDefinition = new WorkflowDefinition(new Long(1), "Sample Workflow Definition", "Sample Workflow Definition");
		workflowDefinition.setSteps(WorkflowManagerHelper.getSteps());
		return workflowDefinition;
	}
	
	

}
