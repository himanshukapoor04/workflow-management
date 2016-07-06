package com.nagarro.cwms.webadmin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.cwms.cache.ProjectDefinitionCache;
import com.nagarro.cwms.helper.WorkflowManagerHelper;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		if (!(ProjectDefinitionCache.getInstance().getAllProjects() != null && !ProjectDefinitionCache
				.getInstance().getAllProjects().isEmpty())) {
			WorkflowManagerHelper.populateCacheOnInit();
		}
		return modelAndView;
	}
}
