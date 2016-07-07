package com.nagarro.cwms.model;

import java.io.Serializable;
import java.util.List;

import com.nagarro.cwms.execution.model.Project;

/**
 * Definition class of workflow.
 * 
 */
public class WorkflowDefinition implements Serializable {

    /** Generated Serial Version Id */
    private static final long serialVersionUID = 3023091256898299593L;
    private long id;
    private String name;
    private String description;
    private List<Step> steps;
    private Project project;


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


    public List<Step> getSteps() {
        return steps;
    }


    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }


    public Project getProject() {
        return project;
    }


    public void setProject(Project project) {
        this.project = project;
    }

}
