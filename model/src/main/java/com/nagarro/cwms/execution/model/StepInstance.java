package com.nagarro.cwms.execution.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.nagarro.cwms.model.Step;

/**
 * Step Instance details which are linked to the workflow instance and step instance.
 * 
 */
public class StepInstance implements Serializable {
    
    
    /** Generated Serial Version ID */
    private static final long serialVersionUID = 8754616046088074573L;
    private long id;
    private Step step;
    private WorkflowInstance workflowInstance;
    private InstanceState stepState;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public Step getStep() {
        return step;
    }


    public void setStep(Step step) {
        this.step = step;
    }


    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }


    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }


    public InstanceState getStepState() {
        return stepState;
    }


    public void setStepState(InstanceState stepState) {
        this.stepState = stepState;
    }


    public Date getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public Date getUpdatedDate() {
        return updatedDate;
    }


    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public StepInstance(Step step, WorkflowInstance workflowInstance) {
        this.step = step;
        this.stepState = InstanceState.RUNNABLE;
        this.workflowInstance = workflowInstance;
        /* Dummy random generator for POC to be replaced by entity manager */
        this.id = ThreadLocalRandom.current().nextLong(10000);
    }

}
