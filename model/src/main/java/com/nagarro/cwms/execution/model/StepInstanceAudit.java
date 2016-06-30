package com.nagarro.cwms.execution.model;

/**
 * POJO to maintain the step execution details. It will contains step instance
 * which is currently running along with it comments will be stored which will
 * allow user to add the comments which will be storing the comments for
 * instance blocking or waiting.
 * 
 */
public class StepInstanceAudit {

	private long id;
	private StepInstance stepInstance;
	private InstanceState changedState;
	private String comments;

	public StepInstanceAudit() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StepInstance getStepInstance() {
		return stepInstance;
	}

	public void setStepInstance(StepInstance stepInstance) {
		this.stepInstance = stepInstance;
	}

	public InstanceState getChangedState() {
		return changedState;
	}

	public void setChangedState(InstanceState changedState) {
		this.changedState = changedState;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
