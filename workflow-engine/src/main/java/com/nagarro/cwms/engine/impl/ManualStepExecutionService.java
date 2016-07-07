package com.nagarro.cwms.engine.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.cache.StepInstanceCache;
import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.ManualStep;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.service.StepManager;

/**
 * Service layer to define the logic for the manual step related operations.
 *
 */
@Stateless
public class ManualStepExecutionService implements StepExecutionService {
	
	@EJB
	StepManager stepManager;
	
	@Override
	public NextState executeStep(ExecutionContext executionContext, Step step,
			WorkflowInstance workflowInstance) throws CWMSServiceException {
		ManualStep manualStep = (ManualStep) step;
		StepInstance stepInstance = stepManager.createStepInstance(manualStep, workflowInstance);
		if(manualStep.getAssigne().getStepsToApprove() != null) {
			manualStep.getAssigne().getStepsToApprove().add(stepInstance);
		} else {
			List<StepInstance> stepToApprove = new ArrayList<StepInstance>();
			stepToApprove.add(stepInstance);
			manualStep.getAssigne().setStepsToApprove(stepToApprove);
		}
		stepInstance.setStepState(InstanceState.BLOCKED);
		StepInstanceCache.getInstance().put(stepInstance.getId(), stepInstance);
		return NextState.BLOCKED;
	}

}
