package com.nagarro.cwms.service;

import java.util.List;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.UserMailMessages;
import com.nagarro.cwms.model.User;

/**
 * Service layer class for managing all the operations related to User.
 * 
 */
@Local
public interface UserManager {

    /**
     * Get User Objects with its Id.
     * 
     * @param id for which user is needed
     * @return User object
     */
    User getUserById(long id);


    /**
     * Get list of user mail messages for a user.
     * 
     * @param user for which mail message is needed
     * @return List of mail messages
     */
    List<UserMailMessages> getUserMailMessages(User user);


    /**
     * Execute workflow for a user.
     * 
     * @param workflowId
     * @param workflowInstanceId
     * @param stepInstanceId
     * @param userId
     */
    void executeWorkflow(long workflowId, long workflowInstanceId, long stepInstanceId, long userId);
}
