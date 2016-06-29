package com.nagarro.cwms.webadmin.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/workflow")
public class WorkflowInstanceController {

	@RequestMapping(value="/allWorkflows",method = RequestMethod.GET)
	public ModelAndView showWorkflows() {
		ModelAndView model = new ModelAndView();
		model.setViewName("showWorkFlow");
		model.addObject("workflows",new ArrayList<Object>());
		return model;
	}
}
