package com.nagarro.cwms.execution.model;

/**
 * ENUM for maintaining the states of the instances. For every instance @see
 * {com.nagarro.cwms.execution.model.WorkflowInstance} state will be maintained.
 * 
 */
public enum InstanceState {
	RUNNABLE, RUNNING, WAITING, BLOCKED, FINISHED;

}
