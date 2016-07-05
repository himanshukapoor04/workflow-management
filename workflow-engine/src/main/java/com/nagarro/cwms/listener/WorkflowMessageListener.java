package com.nagarro.cwms.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;

@MessageDriven(activationConfig = {
			@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
			@ActivationConfigProperty(propertyName = "destination", propertyValue="queue/test")}
		)

public class WorkflowMessageListener implements MessageListener {

	@EJB
	WorkflowEngine workflowEngine;
	
	@Override
	public void onMessage(Message message) {
		try {
			if(message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				WorkflowMessage workflowMessage = (WorkflowMessage) objectMessage.getObject();
				workflowEngine.execute(workflowMessage);
			}
		} catch (JMSException jmsException) {
			//throw new CWMSServiceException("Exception occured while consuming message", jmsException);
		} catch (CWMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
