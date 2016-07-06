package com.nagarro.cwms.model;

import java.util.List;

import com.nagarro.cwms.execution.model.StepInstance;

public class User {
	private Long id;
	private String userName;
	private String password;
	private List<StepInstance> stepsToApprove;
	
	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<StepInstance> getStepsToApprove() {
		return stepsToApprove;
	}
	public void setStepsToApprove(List<StepInstance> stepsToApprove) {
		this.stepsToApprove = stepsToApprove;
	}
	
	
}
