package com.nagarro.cwms.webadmin.web.controller;

import java.util.ArrayList;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

@Controller
@RequestMapping(value="/workflow")
public class WorkflowInstanceController {
	
	@EJB(mappedName="java:module/WorkflowManagerImpl")
	private WorkflowManager workflowManager;
	
	
	@RequestMapping(value="/allWorkflows",method = RequestMethod.GET)
	public ModelAndView showWorkflows() {
		ModelAndView model = new ModelAndView();
		//workflowManager.getWorkflowDefinition();
		model.setViewName("showWorkFlow");
		model.addObject("workflows",new ArrayList<Object>());
		return model;
	}
	
	@RequestMapping(value = "/processWorkflowInstance/{workflowId}", method = RequestMethod.GET)
	public ModelAndView processWorkFlowInstance(@PathVariable int workflowId) {
		ModelAndView modelAndView = new ModelAndView();
		WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinition();
		workflowManager.createWorkflowInstance(workflowDefinition);
		return modelAndView;
	}
}
