package com.nagarro.cwms.execution.model;

import java.io.Serializable;
import java.util.List;

import com.nagarro.cwms.model.WorkflowDefinition;

public class Project implements Serializable{
	
	/** Default Serial Version Id*/
	private static final long serialVersionUID = 8508739311769408608L;
	private Long id;
	private String name;
	private String description;
	private List<WorkflowDefinition> workflows;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public List<WorkflowDefinition> getWorkflows() {
		return workflows;
	}
	public void setWorkflows(List<WorkflowDefinition> workflows) {
		this.workflows = workflows;
	}
	
	public Project() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
