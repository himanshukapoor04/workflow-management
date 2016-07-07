package com.nagarro.cwms.model;

import java.io.Serializable;
import java.util.List;

import com.nagarro.cwms.execution.model.StepInstance;

/**
 * Model class for User.
 *
 */
public class User implements Serializable {
    
    /** Generated Serial Version id */
    private static final long serialVersionUID = 4182536646124432915L;
    private Long id;
    private String userName;
    private String password;
    private List<StepInstance> stepsToApprove;


    public User() {
        super();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public List<StepInstance> getStepsToApprove() {
        return stepsToApprove;
    }


    public void setStepsToApprove(List<StepInstance> stepsToApprove) {
        this.stepsToApprove = stepsToApprove;
    }

}
