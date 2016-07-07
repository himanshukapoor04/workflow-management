package com.nagarro.cwms.webadmin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.cwms.cache.ProjectDefinitionCache;

/**
 * Controller for project related operations. 
 *
 */
@Controller
@RequestMapping(value="/project")
public class ProjectController {
	
    /**
     * Method to get all the projects. 
     */
	@RequestMapping(value = "/showAll", method = RequestMethod.GET )
	public ModelAndView getAllProjects() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("projects", ProjectDefinitionCache.getInstance().getAllProjects());
		modelAndView.setViewName("project");
		return modelAndView;
	}
	
}
