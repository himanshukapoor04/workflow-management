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
 * Service layer to define all the execution related to steps of type of form.
 * 
 */
@Stateless
public class FormStepExecutionService implements StepExecutionService {

    @EJB
    StepManager stepManager;
    
    @Override
    public NextState executeStep(ExecutionContext executionContext, Step step, WorkflowInstance workflowInstance)
            throws CWMSServiceException {
        // TODO Auto-generated method stub
        return NextState.RUN;

    }

}
