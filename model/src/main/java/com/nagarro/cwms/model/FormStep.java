package com.nagarro.cwms.model;

import java.util.Map;

public class FormStep {
	
	private long id;
	private String name;
	private String description;
	private Map<String,String> formProperties;
	
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
	public Map<String, String> getFormProperties() {
		return formProperties;
	}
	public void setFormProperties(Map<String, String> formProperties) {
		this.formProperties = formProperties;
	}
	
}
