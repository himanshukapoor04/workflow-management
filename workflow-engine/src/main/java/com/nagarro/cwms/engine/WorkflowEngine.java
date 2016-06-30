package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;

@Local
public interface WorkflowEngine {
	
	void execute(WorkflowMessage message) throws CWMSException;
}
