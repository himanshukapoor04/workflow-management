package com.nagarro.cwms.service;

import javax.ejb.Local;

import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;

/**
 * Producer service for populating the Queue with workflow related messages.
 * 
 */
@Local
public interface WorkflowMessageSender {

    /**
     * Send a workflow message to the queue. Messages can be sent when user will start an instance of the workflow or some one approves a
     * manual workflow.
     * 
     * @param message which needs to be sent to th queue for processing.
     * @throws CWMSServiceException
     */
    public void sendMessage(WorkflowMessage message) throws CWMSServiceException;

}
