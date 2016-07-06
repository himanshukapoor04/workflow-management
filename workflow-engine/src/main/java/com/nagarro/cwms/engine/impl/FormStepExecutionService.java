package com.nagarro.cwms.engine.impl;

import javax.ejb.Stateless;

import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;

@Stateless
public class FormStepExecutionService implements StepExecutionService {

	@Override
	public NextState executeStep(ExecutionContext executionContext, Step step,
			WorkflowInstance workflowInstance) throws CWMSServiceException {
		// TODO Auto-generated method stub
		return NextState.RUN;

	}

}
