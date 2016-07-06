package com.nagarro.cwms.service;

import java.util.List;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.UserMailMessages;
import com.nagarro.cwms.model.User;

@Local
public interface UserManager {
	
	User getUserById(long id);
	
	List<UserMailMessages> getUserMailMessages(User user);
	
	void executeWorkflow(long workflowId, long workflowInstanceId, long stepInstanceId, long userId);
}
