package com.nagarro.cwms.webadmin.web.controller;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.cwms.execution.model.UserMailMessages;
import com.nagarro.cwms.model.User;
import com.nagarro.cwms.service.UserManager;

/**
 * Controller to do all the user related operations
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @EJB(mappedName = "java:module/UserManagerImpl")
    UserManager userManager;

    /**
     * Method to get all the user's messages.
     * 
     * @param userId for which messages are needed/
     * @return
     */
    @RequestMapping("/mailbox/{userId}")
    public ModelAndView showUserMessages(@PathVariable long userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userMailBox");
        User user = userManager.getUserById(userId);
        List<UserMailMessages> messages = userManager.getUserMailMessages(user);
        modelAndView.addObject("user", user);
        modelAndView.addObject("mailMessages", messages);
        return modelAndView;
    }
    
    /**
     * Method to approve the step.
     * 
     * @param workflowId
     * @param workflowInstanceId
     * @param stepInstanceId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/approveStep/{workflowId}/{workflowInstanceId}/{stepInstanceId}/{userId}", method = RequestMethod.GET)
    public ModelAndView approveStep(@PathVariable long workflowId, @PathVariable long workflowInstanceId,
            @PathVariable long stepInstanceId, @PathVariable long userId) {
        ModelAndView modelAndView = new ModelAndView();
        userManager.executeWorkflow(workflowId, workflowInstanceId, stepInstanceId, userId);
        User user = userManager.getUserById(userId);
        List<UserMailMessages> messages = userManager.getUserMailMessages(user);
        modelAndView.addObject("user", user);
        modelAndView.addObject("mailMessages", messages);
        modelAndView.setViewName("userMailBox");
        return modelAndView;
    }
}
