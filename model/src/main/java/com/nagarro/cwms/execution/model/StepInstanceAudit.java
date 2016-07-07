package com.nagarro.cwms.execution.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * POJO to maintain the step execution details. It will contains step instance which is currently running along with it comments will be
 * stored which will allow user to add the comments which will be storing the comments for instance blocking or waiting.
 * 
 */
public class StepInstanceAudit implements Serializable {

    /** Generated Serial Version Id */
    private static final long serialVersionUID = -6782723934202171509L;
    private long id;
    private StepInstance stepInstance;
    private InstanceState changedState;
    private String comments;
    private Date changedDate;


    public StepInstanceAudit() {
        super();
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public StepInstance getStepInstance() {
        return stepInstance;
    }


    public void setStepInstance(StepInstance stepInstance) {
        this.stepInstance = stepInstance;
    }


    public InstanceState getChangedState() {
        return changedState;
    }


    public void setChangedState(InstanceState changedState) {
        this.changedState = changedState;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }


    public Date getChangedDate() {
        return changedDate;
    }


    public StepInstanceAudit(StepInstance stepInstance, InstanceState changedState, String comments) {
        super();
        this.id = ThreadLocalRandom.current().nextLong(10000);
        this.stepInstance = stepInstance;
        this.changedState = changedState;
        this.comments = comments;
        this.changedDate = new Date();
    }

}
