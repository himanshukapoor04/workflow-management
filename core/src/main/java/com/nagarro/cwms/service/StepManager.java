package com.nagarro.cwms.service;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.StepInstanceAudit;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;

@Local
public interface StepManager {
	
	StepInstance createStepInstance(Step step, WorkflowInstance workflowInstance);
	
	StepInstanceAudit createStepInstanceAudit(StepInstance stepInstance, InstanceState changedState, String comments);

}
