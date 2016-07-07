package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;

/**
 * Class to define the logic for every type of Step.
 * 
 */
@Local
public interface StepExecutionService {

    /**
     * Method which will be executing once a step is executed.
     * 
     * @param executionContext
     * @param step
     * @param workflowInstance
     * @return
     * @throws CWMSServiceException
     */
    NextState executeStep(ExecutionContext executionContext, Step step, WorkflowInstance workflowInstance) throws CWMSServiceException;

}
