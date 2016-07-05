package com.nagarro.cwms.service.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.service.WorkflowMessageSender;

@Stateless
public class WorkflowMessageSenderImpl implements WorkflowMessageSender {
	
	@Resource(mappedName = "java:jboss/exported/jms/queue/test")
	private Queue queue;
	
	@Resource(mappedName = "java:/JmsXA")
	private ConnectionFactory factory;
	
	public void sendMessage(WorkflowMessage message) {
		Connection connection = null;
		Session session = null;
		try {
			connection = factory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
			connection.start();
			ObjectMessage objectMessage = session.createObjectMessage(message);
			producer.send(objectMessage);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
