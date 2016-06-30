package com.nagarro.cwms.execution.model;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * Workflow Instance entity. It will store the instance details of the workflow.
 *  
 *
 */
public class WorkflowInstance implements Serializable {

	/** Default Serial Version Id*/
	private static final long serialVersionUID = -11346497263010661L;
	private long id;
	private WorkflowDefinition workflow;
	private InstanceState workflowState;
	
	public WorkflowInstance() {
		super();
	}
	
	public WorkflowInstance(WorkflowDefinition workflow) {
		/* Dummy random generator for POC to be replaced by entity manager */
		this.id = ThreadLocalRandom.current().nextLong(10000);
		this.workflow = workflow;
		this.workflowState = InstanceState.RUNNABLE;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WorkflowDefinition getWorkflow() {
		return workflow;
	}

	public void setWorkflow(WorkflowDefinition workflow) {
		this.workflow = workflow;
	}

	public InstanceState getWorkflowState() {
		return workflowState;
	}

	public void setWorkflowState(InstanceState workflowState) {
		this.workflowState = workflowState;
	}

}
