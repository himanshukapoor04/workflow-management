package com.nagarro.cwms.execution.model;

import java.io.Serializable;

public class UserMailMessages implements Serializable {
	
	
	/** Serial version Id	 */
	private static final long serialVersionUID = 2478908010236123681L;
	
	private Long stepInstanceId;
	private Long workflowId;
	private Long workflowInstanceId;
	private String message;
	
	public Long getStepInstanceId() {
		return stepInstanceId;
	}
	public void setStepInstanceId(Long stepInstanceId) {
		this.stepInstanceId = stepInstanceId;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
