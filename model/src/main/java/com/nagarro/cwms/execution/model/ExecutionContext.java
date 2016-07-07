package com.nagarro.cwms.execution.model;

import java.util.Map;

/**
 * Context class to carry parameters across the workflow.
 * 
 */
public class ExecutionContext {

    /** Result variables from a step. */
    private Map<String, Object> resultVariables;

    /** Input varibles to a step. */
    private Map<String, Object> inputVariables;


    /**
     * Getter for result varaibles.
     * 
     * @return
     */
    public Map<String, Object> getResultVariables() {
        return resultVariables;
    }


    /**
     * Setter for result variables.
     * 
     * @param resultVariables
     */
    public void setResultVariables(Map<String, Object> resultVariables) {
        this.resultVariables = resultVariables;
    }


    /**
     * Getter for input variables.
     * 
     * @return map of input variables
     */
    public Map<String, Object> getInputVariables() {
        return inputVariables;
    }


    /**
     * Setter for input variables.
     * 
     * @param inputVariables
     */
    public void setInputVariables(Map<String, Object> inputVariables) {
        this.inputVariables = inputVariables;
    }

}
