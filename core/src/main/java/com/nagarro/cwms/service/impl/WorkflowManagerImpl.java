package com.nagarro.cwms.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;
import com.nagarro.cwms.service.WorkflowMessageSender;

@Stateless(mappedName="ejb/WorkflowManager")
public class WorkflowManagerImpl implements WorkflowManager {

	@EJB
	WorkflowMessageSender messageSender;
	
	public WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition) {
		WorkflowInstance workflowInstance = new WorkflowInstance(workflowDefinition);
		WorkflowMessage workflowMessage = new WorkflowMessage(workflowInstance.getId());
		messageSender.sendMessage(workflowMessage);
		return workflowInstance;
	}

	public WorkflowDefinition getWorkflowDefinition() {
		return new WorkflowDefinition();
	}

}
