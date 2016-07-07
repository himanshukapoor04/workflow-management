package com.nagarro.cwms.webadmin.servlet;

import javax.servlet.http.HttpServlet;

import com.nagarro.cwms.helper.WorkflowManagerHelper;

/**
 * Init servlet for loading the class configuration. 
 *
 */
public class InitServlet extends HttpServlet {
    
    /** Generated Serial version id. */
    private static final long serialVersionUID = 6840623013841745438L;
    
    /**
     * Initializing cache at start up.
     */
    @Override
    public void init() {
        WorkflowManagerHelper.populateCacheOnInit();
    }
}
