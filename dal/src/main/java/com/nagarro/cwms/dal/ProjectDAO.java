package com.nagarro.cwms.dal;

import javax.ejb.Local;

import com.nagarro.cwms.execution.model.Project;

/**
 * DAO for project related operations.
 * 
 */
@Local
public interface ProjectDAO extends BaseDAO<Project, Long> {

    /**
     * Get a Project with its id.
     * 
     * @param projectId
     * @return
     */
    Project findProjectByID(Long projectId);
}
