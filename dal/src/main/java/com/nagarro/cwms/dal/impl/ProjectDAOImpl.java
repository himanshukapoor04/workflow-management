package com.nagarro.cwms.dal.impl;

import javax.ejb.Stateless;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.dal.ProjectDAO;
import com.nagarro.cwms.execution.model.Project;

/**
 * Implementation class for the DAO related operations 
 *
 */
@Stateless
public class ProjectDAOImpl extends BaseDAOImpl<Project, Long> implements ProjectDAO {

	@Override
	public Project findProjectByID(Long projectId) {
		return ProjectDefinitionCache.getInstance().getProjectById(projectId);
	}
}
