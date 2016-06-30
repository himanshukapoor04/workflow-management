package com.nagarro.cwms.execution.model;

import java.util.Date;

import com.nagarro.cwms.model.Step;

/**
 * Step Instance details which are linked to the workflow instance and step
 * instance.
 * 
 */
public class StepInstance {

	private long id;
	private Step step;
	private WorkflowInstance workflowInstance;
	private InstanceState stepState;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public WorkflowInstance getWorkflowInstance() {
		return workflowInstance;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	public InstanceState getStepState() {
		return stepState;
	}

	public void setStepState(InstanceState stepState) {
		this.stepState = stepState;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
