package com.nagarro.cwms.dal.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.dal.WorkflowDAO;
import com.nagarro.cwms.execution.model.Project;
import com.nagarro.cwms.model.WorkflowDefinition;

/**
 * Implementation class for Workflow related operations.
 *
 */
@Stateless
public class WorkflowDAOImpl extends BaseDAOImpl<WorkflowDefinition, Long> implements WorkflowDAO {

	@Override
	public List<WorkflowDefinition> getAllWorkflows() {
		return ProjectDefinitionCache.getInstance().getAllWorkflowDefinitions();
	}
	
	@Override
	public List<WorkflowDefinition> getWorkflowsByProject(Project project) {
		return ProjectDefinitionCache.getInstance().getWorkflowsByProject(project);
	}

}
