package com.nagarro.cwms.engine.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.engine.StepExecutionServiceFactory;
import com.nagarro.cwms.model.FormStep;
import com.nagarro.cwms.model.ManualStep;
import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;

/**
 * Factory class to get the service to execute the task.
 * 
 */
@Stateless
public class StepExecutionServiceFactoryBean implements StepExecutionServiceFactory {

    @EJB(beanName = "ScriptStepExecutionService")
    private StepExecutionService scriptStepExecutionService;

    @EJB(beanName = "FormStepExecutionService")
    private StepExecutionService formStepExecutionService;

    @EJB(beanName = "ManualStepExecutionService")
    private StepExecutionService manualStepExecutionService;

    @EJB(beanName = "RuleStepExecutionService")
    private StepExecutionService ruleStepExecutionService;


    @Override
    public StepExecutionService getStepExecutionService(Step step) {
        if (step instanceof ScriptStep) {
            return scriptStepExecutionService;
        } else if (step instanceof FormStep) {
            return formStepExecutionService;
        } else if (step instanceof ManualStep) {
            return manualStepExecutionService;
        }
        return null;
    }

}
