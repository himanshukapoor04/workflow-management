package com.nagarro.cwms.helper;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.cache.UserInstanceCache;
import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.model.ManualStep;
import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.model.User;
import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * Helper class to generate the data with which the application will run. In real time it would be replaced by service class which will get
 * the data from the Database through DAO and will populate the cache.
 * 
 */
public class WorkflowManagerHelper {

    /**
     * Helper method to get the list of steps.
     * 
     * @return List of Step
     */
    public static List<Step> getSteps() {
        ScriptStep scriptStep = new ScriptStep();
        scriptStep.setDescription("Sample Script");
        scriptStep.setId(new Long(1));
        scriptStep.setFileName("Script.js");
        scriptStep.setName("Sample Script");
        ManualStep manualStep = new ManualStep();
        manualStep.setAssigne(UserInstanceCache.getInstance().get(new Long(1)));
        manualStep.setDescription("Sample manual step");
        manualStep.setName("Sample manual Step");
        manualStep.setTaskDetails("Please approve step.");
        List<Step> steps = new ArrayList<Step>();
        steps.add(scriptStep);
        steps.add(manualStep);
        return steps;
    }


    /**
     * Helper method to populate the cache.
     */
    public static void populateCacheOnInit() {
        User user = new User();
        user.setId(new Long(1));
        user.setUserName("Admin");
        UserInstanceCache.getInstance().put(new Long(1), user);
        Project project = new Project();
        project.setName("Sample Project");
        project.setDescription("Sample Project");
        project.setId(new Long(1));
        List<WorkflowDefinition> workflowDefinitions = new ArrayList<WorkflowDefinition>();
        WorkflowDefinition workflowDefinition1 = new WorkflowDefinition(new Long(1), "Sample Workflow Definition 1",
                "Sample Workflow Definition 1");
        workflowDefinition1.setSteps(WorkflowManagerHelper.getSteps());
        workflowDefinition1.setProject(project);
        workflowDefinitions.add(workflowDefinition1);
        WorkflowDefinition workflowDefinition2 = new WorkflowDefinition(new Long(2), "Sample Workflow Definition 2",
                "Sample Workflow Definition 2");
        workflowDefinition2.setSteps(WorkflowManagerHelper.getSteps());
        workflowDefinition2.setProject(project);
        workflowDefinitions.add(workflowDefinition2);
        project.setWorkflows(workflowDefinitions);
        ProjectDefinitionCache.getInstance().put(project, workflowDefinition1);
        ProjectDefinitionCache.getInstance().put(project, workflowDefinition2);

    }
}
