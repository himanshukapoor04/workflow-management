package com.nagarro.cwms.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagarro.cwms.dal.ProjectDAO;
import com.nagarro.cwms.dal.WorkflowDAO;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;
import com.nagarro.cwms.service.WorkflowMessageSender;

/**
 * Implementation class for workflow service class.
 * 
 */
@Stateless
public class WorkflowManagerImpl implements WorkflowManager {

    private static final Logger LOG = LoggerFactory.getLogger(WorkflowManagerImpl.class);
    
    @EJB
    WorkflowMessageSender messageSender;

    @EJB
    WorkflowDAO workflowDAO;

    @EJB
    ProjectDAO projectDAO;


    @Override
    public void startWorkflowInstance(WorkflowDefinition workflowDefinition) {
        WorkflowMessage workflowMessage = new WorkflowMessage(workflowDefinition.getId());
        try {
            messageSender.sendMessage(workflowMessage);
        } catch (CWMSServiceException exception) {
            LOG.error("Exception occured while sending message", exception);
        }
    }


    @Override
    public WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition) {
        WorkflowInstance workflowInstance = new WorkflowInstance(workflowDefinition);
        return workflowInstance;
    }


    @Override
    public List<WorkflowDefinition> getAllWorkflowDefinition() {
        return workflowDAO.getAllWorkflows();
    }


    @Override
    public WorkflowDefinition getWorkflowDefinitionById(Long id) {
        /* Returning hard coded data would be replaced by Cache look up and DB look up if not found in cache. */
        List<WorkflowDefinition> workflowDefinitions = workflowDAO.getAllWorkflows();
        for (WorkflowDefinition workflowDefinition : workflowDefinitions) {
            if (workflowDefinition.getId() == id.longValue()) {
                return workflowDefinition;
            }
        }
        return null;
    }


    @Override
    public List<WorkflowDefinition> getWorkflowsByProject(Long projectId) {
        Project project = projectDAO.findProjectByID(projectId);
        return workflowDAO.getWorkflowsByProject(project);
    }

}
