package com.nagarro.cwms.execution.model;

import java.util.Map;

/**
 * Context class to carry parameters across the workflow. 
 *
 */
public class ExecutionContext {
	
	private Map<String, Object> resultVariables;
	
	private Map<String,Object> inputVariables;

	public Map<String, Object> getResultVariables() {
		return resultVariables;
	}

	public void setResultVariables(Map<String, Object> resultVariables) {
		this.resultVariables = resultVariables;
	}

	public Map<String, Object> getInputVariables() {
		return inputVariables;
	}

	public void setInputVariables(Map<String, Object> inputVariables) {
		this.inputVariables = inputVariables;
	}
	
	
	
	
}
