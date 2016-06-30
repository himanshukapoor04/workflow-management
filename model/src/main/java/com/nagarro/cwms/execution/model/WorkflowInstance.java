package com.nagarro.cwms.execution.model;

import com.nagarro.cwms.model.Workflow;

/**
 * Workflow Instance entity. It will store the instance details of the workflow.
 *  
 *
 */
public class WorkflowInstance {

	private long id;
	private Workflow workflow;
	private InstanceState workflowState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public InstanceState getWorkflowState() {
		return workflowState;
	}

	public void setWorkflowState(InstanceState workflowState) {
		this.workflowState = workflowState;
	}

}
