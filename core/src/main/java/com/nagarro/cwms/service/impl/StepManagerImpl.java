package com.nagarro.cwms.service.impl;

import javax.ejb.Stateless;

import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.StepInstanceAudit;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.service.StepManager;

@Stateless
public class StepManagerImpl implements StepManager {

	public StepInstance createStepInstance(Step step, WorkflowInstance workflowInstance) {
		StepInstance stepInstance = new StepInstance(step, workflowInstance);
		return stepInstance;
	}

	public StepInstanceAudit createStepInstanceAudit(StepInstance stepInstance,
			InstanceState changedState, String comments) {
		StepInstanceAudit stepInstanceAudit = new StepInstanceAudit(stepInstance, changedState, comments);
		return stepInstanceAudit;
	}
	
	

}
