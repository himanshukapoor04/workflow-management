package com.nagarro.cwms.execution.model;

import java.io.Serializable;

/**
 * It maintains the audit history of the workflow. It will maintain the instance id for which the workflow is initiated. Along with that
 * reference to the Step where the workflow instance is present will also be stored. It will store system comments as well in order to show
 * the logs if some one wants to see why the workflow got blocked or in
 * 
 */
public class WorkflowInstanceAudit implements Serializable {

    /** Generated Serial Version Id */
    private static final long serialVersionUID = 5451316743517918524L;
    private long id;
    private WorkflowInstance workflowInstance;
    private InstanceState state;
    private StepInstance ownerStep;
    private String comment;


    public WorkflowInstanceAudit() {
        super();
    }


    public WorkflowInstanceAudit(long id, WorkflowInstance workflowInstance, InstanceState state, StepInstance ownerStep, String comment) {
        super();
        this.id = id;
        this.workflowInstance = workflowInstance;
        this.state = state;
        this.ownerStep = ownerStep;
        this.comment = comment;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }


    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }


    public InstanceState getState() {
        return state;
    }


    public void setState(InstanceState state) {
        this.state = state;
    }


    public StepInstance getOwnerStep() {
        return ownerStep;
    }


    public void setOwnerStep(StepInstance ownerStep) {
        this.ownerStep = ownerStep;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

}
