package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.model.Step;

@Local
public interface StepExecutionServiceFactory {
	
	StepExecutionService getStepExecutionService(Step step);
}
