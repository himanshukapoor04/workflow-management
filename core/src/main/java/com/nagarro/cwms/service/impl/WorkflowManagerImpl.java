package com.nagarro.cwms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.helper.WorkflowManagerHelper;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;
import com.nagarro.cwms.service.WorkflowMessageSender;

@Stateless(mappedName="ejb/WorkflowManager")
public class WorkflowManagerImpl implements WorkflowManager {

	@EJB
	WorkflowMessageSender messageSender;
	
	public void startWorkflowInstance(WorkflowDefinition workflowDefinition) {
		WorkflowMessage workflowMessage = new WorkflowMessage(workflowDefinition.getId());
		messageSender.sendMessage(workflowMessage);
	}
	
	public WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition) {
		WorkflowInstance workflowInstance = new WorkflowInstance(workflowDefinition);
		return workflowInstance;
	}

	public List<WorkflowDefinition> getAllWorkflowDefinition() {
		List<WorkflowDefinition> workflowDefinitions = new ArrayList<WorkflowDefinition>();
		ProjectDefinitionCache.getInstance().getAllWorkflowDefinitions();
		return workflowDefinitions;
	}
	
	public WorkflowDefinition getWorkflowDefinitionById(Long id) {
		/* Returning hard coded data would be replaced by Cache look up and DB look up if not found in cache. */
		List<WorkflowDefinition> workflowDefinitions = ProjectDefinitionCache.getInstance().getAllWorkflowDefinitions();
		for(WorkflowDefinition workflowDefinition : workflowDefinitions ) {
			if(workflowDefinition.getId() == id.longValue()) {
				return workflowDefinition;
			}
		}
		return null;
	}
	
	public List<WorkflowDefinition> getWorkflowsByProject(Long projectId) {
		Project project = ProjectDefinitionCache.getInstance().getProjectById(projectId);
		return ProjectDefinitionCache.getInstance().getWorkflowsByProject(project);
	}
	
	

}
