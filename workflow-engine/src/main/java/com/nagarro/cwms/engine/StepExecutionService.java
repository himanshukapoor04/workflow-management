package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;

@Local
public interface StepExecutionService {

	void executeStep(ExecutionContext executionContext, Step step,
			WorkflowInstance workflowInstance) throws CWMSServiceException;

}
