package com.nagarro.cwms.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * Temporary cache to hold the Project's workflows. In long run it
 * would be replaced by Infinispan.
 * 
 */
public class ProjectDefinitionCache {

	private static ProjectDefinitionCache INSTACE = new ProjectDefinitionCache();

	private ProjectDefinitionCache() {

	}

	private Map<Project, List<WorkflowDefinition>> cache = new ConcurrentHashMap<>();

	public synchronized void put(Project project, WorkflowDefinition workflowDefinition) {
		if (cache.containsKey(project)) {
			cache.get(project).add(workflowDefinition);
		} else {
			List<WorkflowDefinition> workflows = new ArrayList<>();
			workflows.add(workflowDefinition);
			cache.put(project, workflows);
		}
	}

	public synchronized void remove(Project project) {
		if (cache.containsKey(project)) {
			cache.remove(project);
		}
	}
	
	public List<WorkflowDefinition> getWorkflowsByProject(Project project) {
		return cache.get(project);
	}
	
	public List<WorkflowDefinition> getAllWorkflowDefinitions() {
		List<WorkflowDefinition> workflows = new ArrayList<WorkflowDefinition>();
		for(Project project : cache.keySet()) {
			workflows.addAll(cache.get(project));
		}
		return workflows;
	}
	
	public Project getProjectById(Long id) {
		for(Project project : cache.keySet()) {
			if(project.getId().longValue() == id.longValue()) {
				return project;
			}
		}
		return null;
	}
	
	public Set<Project> getAllProjects() {
		return cache.keySet();
	}

	public static ProjectDefinitionCache getInstance() {
		return INSTACE;
	}
}
