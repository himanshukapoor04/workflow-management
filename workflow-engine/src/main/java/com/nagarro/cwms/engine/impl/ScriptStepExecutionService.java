package com.nagarro.cwms.engine.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.service.StepManager;

@Stateless
public class ScriptStepExecutionService implements StepExecutionService  {
	
	@EJB
	private StepManager stepManager;
	
	public void executeStep(ExecutionContext executionContext,
			Step step, WorkflowInstance workflowInstance) throws CWMSServiceException {
		if(executionContext == null ) {
			throw new CWMSServiceException("Invalid execution context.");
		}
		if(step == null || workflowInstance == null) {
			throw new CWMSServiceException("Invalid data entered.");
		}
		try {
			ScriptStep scriptStep = (ScriptStep) step;
			StepInstance stepInstance = stepManager.createStepInstance(scriptStep, workflowInstance);
			ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
			scriptEngine.eval(new FileReader(new File(scriptStep.getFileLocation())));
		} catch (FileNotFoundException fileNotFoundException) {
			throw new CWMSServiceException("Error executing script", fileNotFoundException);
		} catch (ScriptException scriptException) {
			throw new CWMSServiceException("Error executing script", scriptException);
		}
		
	}

}
