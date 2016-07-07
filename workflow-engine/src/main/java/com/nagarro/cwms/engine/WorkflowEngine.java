package com.nagarro.cwms.engine;

import javax.ejb.Local;

import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;

/**
 * Engine class to execute the workflow isntance.
 * 
 */
@Local
public interface WorkflowEngine {

    /**
     * Execute the workflow with information coming from the workflow message recieved from queue.
     * 
     * @param message
     * @throws CWMSException
     */
    void execute(WorkflowMessage message) throws CWMSException;
}
