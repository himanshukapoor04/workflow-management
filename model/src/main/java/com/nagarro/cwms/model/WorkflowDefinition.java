package com.nagarro.cwms.model;

/**
 * Definition class of workflow. 
 *
 */
public class WorkflowDefinition {
	
	private long id;
	private String name;
	private String description;
	
	public WorkflowDefinition() {
		super();
	}
	
	public WorkflowDefinition(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
