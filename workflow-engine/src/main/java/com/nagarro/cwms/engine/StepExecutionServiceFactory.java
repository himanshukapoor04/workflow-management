package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.model.Step;

/**
 * Factory class to get the service to execute the step depending upon its type.
 * 
 */
@Local
public interface StepExecutionServiceFactory {

    /**
     * Method to get the service according to its type.
     * 
     * @param step
     * @return
     */
    StepExecutionService getStepExecutionService(Step step);
}
