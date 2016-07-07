package com.nagarro.cwms.dal;

import java.util.List;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * DAO for workflow related operations
 * 
 */
@Local
public interface WorkflowDAO extends BaseDAO<WorkflowDefinition, Long> {

    /**
     * Get all workflows from the database.
     * 
     * @return get all workflows
     */
    List<WorkflowDefinition> getAllWorkflows();


    /**
     * Get list of workflow for a project.
     * 
     * @param project
     * @return
     */
    List<WorkflowDefinition> getWorkflowsByProject(Project project);
}
