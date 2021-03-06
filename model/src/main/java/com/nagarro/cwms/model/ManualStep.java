package com.nagarro.cwms.model;

import java.io.Serializable;

/**
 * Entity for manual steps. Manual steps have to be assigned to a user. This step will contain the name of the user to whom the task has to
 * be assigned along with details which she supposed to handle.
 * 
 */
public class ManualStep implements Step, Serializable {

    /** Generated Serial Version Id. */
    private static final long serialVersionUID = -9096507161616101131L;
    private long id;
    private String name;
    private String description;
    private User assigne;
    private String taskDetails;


    public ManualStep() {
        super();
    }


    public ManualStep(long id, String name, String description, User assigne, String taskDetails) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.assigne = assigne;
        this.taskDetails = taskDetails;
    }


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


    public User getAssigne() {
        return assigne;
    }


    public void setAssigne(User assigne) {
        this.assigne = assigne;
    }


    public String getTaskDetails() {
        return taskDetails;
    }


    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

}
