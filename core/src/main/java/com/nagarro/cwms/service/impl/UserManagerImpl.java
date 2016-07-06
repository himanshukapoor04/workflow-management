package com.nagarro.cwms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.nagarro.cwms.cache.UserInstanceCache;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.UserMailMessages;
import com.nagarro.cwms.model.ManualStep;
import com.nagarro.cwms.model.User;
import com.nagarro.cwms.service.UserManager;
import com.nagarro.cwms.service.WorkflowMessageSender;

@Stateless(mappedName="ejb/UserManager")
public class UserManagerImpl implements UserManager {

	@EJB
	WorkflowMessageSender messageSender;
	
	@Override
	public User getUserById(long id) {
		return UserInstanceCache.getInstance().get(id);
	}

	@Override
	public void executeWorkflow(long workflowId, long workflowInstanceId, long stepInstanceId, long userId) {
		WorkflowMessage workflowMessage = new WorkflowMessage(workflowId);
		workflowMessage.setWorkflowInstanceId(workflowInstanceId);
		workflowMessage.setStepInstanceId(stepInstanceId);
		/*Hard coded to remove all messages but will be programmed in better way */
		UserInstanceCache.getInstance().get(userId).getStepsToApprove().clear();
		messageSender.sendMessage(workflowMessage);
	}

	@Override
	public List<UserMailMessages> getUserMailMessages(User user) {
		List<UserMailMessages> messages = new ArrayList<>();
		List<StepInstance> stepInstances = user.getStepsToApprove();
		if(stepInstances != null && !stepInstances.isEmpty()) {
			for(StepInstance stepInstance: stepInstances) {
				UserMailMessages userMailMessage = new UserMailMessages();
				ManualStep manualStep = (ManualStep) stepInstance.getStep();
				userMailMessage.setMessage(manualStep.getTaskDetails());
				userMailMessage.setStepInstanceId(stepInstance.getId());
				userMailMessage.setWorkflowId(stepInstance.getWorkflowInstance().getWorkflow().getId());
				userMailMessage.setWorkflowInstanceId(stepInstance.getWorkflowInstance().getId());
				messages.add(userMailMessage);
				
			}
		}
		return messages;
	}
	
	

}
