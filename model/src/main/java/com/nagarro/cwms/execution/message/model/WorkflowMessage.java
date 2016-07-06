package com.nagarro.cwms.execution.message.model;

import java.io.Serializable;

/**
 * Message class for carrying out the workflow id from queue
 * to the workflow engine. This will be sent when user will type
 * start instance and will be passed back to the main engine class. 
 *
 */
public class WorkflowMessage implements Serializable {
	
	/** Generated Serial version id */
	private static final long serialVersionUID = 5497209310483331230L;
	
	/** Workflow Id which needs to be carried forward */
	private Long workflowId;
	
	private Long workflowInstanceId;
	
	private Long stepInstanceId;
	
	public WorkflowMessage() {
		super();
	}
	
	public WorkflowMessage(Long workflowId) {
		super();
		this.workflowId = workflowId;
	}

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public Long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(Long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public Long getStepInstanceId() {
		return stepInstanceId;
	}

	public void setStepInstanceId(Long stepInstanceId) {
		this.stepInstanceId = stepInstanceId;
	}
	
}
