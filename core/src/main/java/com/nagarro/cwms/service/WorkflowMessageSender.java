package com.nagarro.cwms.service;

import javax.ejb.Local;

import com.nagarro.cwms.execution.message.model.WorkflowMessage;

@Local
public interface WorkflowMessageSender {
	
	public void sendMessage(WorkflowMessage message);

}
