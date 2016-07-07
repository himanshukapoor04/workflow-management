package com.nagarro.cwms.engine.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.service.StepManager;

/**
 * Service to execute the logic for rule base step. It will be using Drool 
 * to verify the steps.
 *
 */
@Stateless
public class RuleStepExecutionService implements StepExecutionService {

    @EJB
    StepManager stepManager;
    
    @Override
	public NextState executeStep(ExecutionContext executionContext, Step step,
			WorkflowInstance workflowInstance) throws CWMSServiceException {
		return NextState.RUN;
	}

}
