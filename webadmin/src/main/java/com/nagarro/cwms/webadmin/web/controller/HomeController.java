package com.nagarro.cwms.webadmin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for home page related operations.
 *
 */
@Controller
public class HomeController {
    
    /**
     * Method to show the home page.
     * @return
     */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
