package com.nagarro.cwms.webadmin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.cwms.cache.WorkflowInstanceCache;
import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

/**
 * Controller for all the workflow related operations.
 *
 */
@Controller
@RequestMapping(value="/workflow")
public class WorkflowInstanceController {
	
	@EJB(mappedName="java:module/WorkflowManagerImpl")
	private WorkflowManager workflowManager;
	
	
	@RequestMapping(value="/allWorkflows",method = RequestMethod.GET)
	public ModelAndView showWorkflows() {
		ModelAndView model = new ModelAndView();
		List<WorkflowDefinition> workflowDefinitions = workflowManager.getAllWorkflowDefinition();
		model.setViewName("showWorkFlow");
		if(workflowDefinitions != null && !workflowDefinitions.isEmpty()) {
			model.addObject("workflows",workflowDefinitions);
		} else {
			model.addObject("errorMessage", "No Workflow Definitions found");
		}
		return model;
	}

	@RequestMapping(value="/allWorkflowsByProject/{projectId}",method = RequestMethod.GET)
	public ModelAndView showWorkflowsByProjectId(@PathVariable long projectId) {
		ModelAndView model = new ModelAndView();
		List<WorkflowDefinition> workflowDefinitions = workflowManager.getWorkflowsByProject(projectId);
		model.setViewName("showWorkFlow");
		if(workflowDefinitions != null && !workflowDefinitions.isEmpty()) {
			model.addObject("workflows",workflowDefinitions);
		} else {
			model.addObject("errorMessage", "No Workflow Definitions found");
		}
		return model;
	}
	
	@RequestMapping(value = "/processWorkflowInstance/{workflowId}", method = RequestMethod.GET)
	public ModelAndView processWorkFlowInstance(@PathVariable long workflowId) {
		ModelAndView modelAndView = new ModelAndView();
		WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinitionById(workflowId);
		workflowManager.startWorkflowInstance(workflowDefinition);
		modelAndView.setViewName("showInstanceMessage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getAllWorkflowInstanceHealth/{workflowId}")
	public ModelAndView getAllWorkflowInstancesHealth(@PathVariable long workflowId) {
		ModelAndView modelAndView = new ModelAndView();
		WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinitionById(workflowId);
		Map<Long, WorkflowInstance> workflowInstances = WorkflowInstanceCache.getInstance().getAllByWorkflowId(workflowId);
		Map<Long, InstanceState> instances = new HashMap<Long, InstanceState>();
		for(Long id : workflowInstances.keySet()) {
			instances.put(id, workflowInstances.get(id).getWorkflowState());
		}
		modelAndView.addObject("instanceHealthStatus", instances);
		modelAndView.addObject("workflow",workflowDefinition);
		modelAndView.setViewName("showHealthStatus");
		return modelAndView;
	}
}
