package com.nagarro.cwms.helper;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.cache.UserInstanceCache;
import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.model.User;
import com.nagarro.cwms.model.WorkflowDefinition;

public class WorkflowManagerHelper {
	
	public static List<Step> getSteps() {
		ScriptStep scriptStep = new ScriptStep();
		scriptStep.setDescription("Sample Script");
		scriptStep.setId(new Long(1));
		scriptStep.setFileName("Script.js");
		scriptStep.setName("Sample Script");
		List<Step> steps = new ArrayList<Step>();
		steps.add(scriptStep);
		return steps;
	}
	
	public static void populateCacheOnInit() {
		Project project = new Project();
		project.setName("Sample Project");
		project.setDescription("Sample Project");
		project.setId(new Long(1));
		List<WorkflowDefinition> workflowDefinitions = new ArrayList<WorkflowDefinition>();
		WorkflowDefinition workflowDefinition1 = new WorkflowDefinition(new Long(1), "Sample Workflow Definition 1", "Sample Workflow Definition 1");
		workflowDefinition1.setSteps(WorkflowManagerHelper.getSteps());
		workflowDefinition1.setProject(project);
		workflowDefinitions.add(workflowDefinition1);
		WorkflowDefinition workflowDefinition2 = new WorkflowDefinition(new Long(2), "Sample Workflow Definition 2", "Sample Workflow Definition 2");
		workflowDefinition2.setSteps(WorkflowManagerHelper.getSteps());
		workflowDefinition2.setProject(project);
		workflowDefinitions.add(workflowDefinition2);
		project.setWorkflows(workflowDefinitions);
		ProjectDefinitionCache.getInstance().put(project, workflowDefinition1);
		ProjectDefinitionCache.getInstance().put(project, workflowDefinition2);
		User user = new User();
		user.setId(new Long(1));
		user.setUserName("Admin");
		UserInstanceCache.getInstance().put(new Long(1), user);
	}
}
