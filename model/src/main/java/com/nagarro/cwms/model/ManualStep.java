package com.nagarro.cwms.model;

public class ManualStep {

	private long id;
	private String name;
	private String description;
	private String assigne;
	private String taskDetails;

	public ManualStep() {
		super();
	}

	public ManualStep(long id, String name, String description, String assigne,
			String taskDetails) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assigne = assigne;
		this.taskDetails = taskDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssigne() {
		return assigne;
	}

	public void setAssigne(String assigne) {
		this.assigne = assigne;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

}