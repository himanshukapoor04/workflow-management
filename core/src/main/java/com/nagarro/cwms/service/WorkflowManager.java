package com.nagarro.cwms.service;

import java.util.List;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * Service layer class for all the workflow related operations.
 * 
 */
@Local
public interface WorkflowManager {

    /**
     * Method to start the workflow instance.
     * 
     * @param workflowDefinition for which instance needs to be created.
     */
    void startWorkflowInstance(WorkflowDefinition workflowDefinition);


    /**
     * Create Workflow instances for workflow definition.
     * 
     * @param workflowDefinition
     * @return
     */
    WorkflowInstance createWorkflowInstance(WorkflowDefinition workflowDefinition);


    /**
     * Get all workflow definitions present in the system.
     * 
     * @return
     */
    List<WorkflowDefinition> getAllWorkflowDefinition();


    /**
     * Get workflow definition with id.
     * 
     * @param id
     * @return
     */
    WorkflowDefinition getWorkflowDefinitionById(Long id);


    /**
     * Get all the workflow definitions for a project.
     * 
     * @param projectId
     * @return
     */
    List<WorkflowDefinition> getWorkflowsByProject(Long projectId);
}
