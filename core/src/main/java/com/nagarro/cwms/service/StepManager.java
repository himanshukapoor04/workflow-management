package com.nagarro.cwms.service;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.StepInstanceAudit;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;

/**
 * Service layer for managing all the operations related to Steps.
 * 
 */
@Local
public interface StepManager {

    /**
     * Create Step Instance for a Step and workflow Instance. For every step in a workflow a step instance will be defined.
     * 
     * @param step with which it will be bound
     * @param workflowInstance with which step instance will be bound.
     * @return Step Instance
     */
    StepInstance createStepInstance(Step step, WorkflowInstance workflowInstance);


    /**
     * Create Step Instance audit for the step. As every step instance will change a step instance audit will be saved so as to make sure
     * that data is trackable.
     * 
     * @param stepInstance for which audit is created
     * @param changedState date on which step instance is created
     * @param comments relevant comments
     * @return
     */
    StepInstanceAudit createStepInstanceAudit(StepInstance stepInstance, InstanceState changedState, String comments);

}
