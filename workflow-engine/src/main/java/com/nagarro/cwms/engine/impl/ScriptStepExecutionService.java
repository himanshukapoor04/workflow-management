package com.nagarro.cwms.engine.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.nagarro.cwms.cache.StepInstanceCache;
import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.StepInstance;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.service.StepManager;

@Stateless
public class ScriptStepExecutionService implements StepExecutionService  {
	
	@EJB
	private StepManager stepManager;
	
	public NextState executeStep(ExecutionContext executionContext,
			Step step, WorkflowInstance workflowInstance) throws CWMSServiceException {
		System.out.println("Inside Script step");
		if(executionContext == null ) {
			throw new CWMSServiceException("Invalid execution context.");
		}
		if(step == null || workflowInstance == null) {
			throw new CWMSServiceException("Invalid data entered.");
		}
		StepInstance stepInstance = null;
		try {
			ScriptStep scriptStep = (ScriptStep) step;
			stepInstance = stepManager.createStepInstance(scriptStep, workflowInstance);
			StepInstanceCache.getInstance().put(stepInstance.getId(), stepInstance);
			ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
			String fileLocation = null;
			if(System.getProperty("JavaScriptFileLocation") != null) {
				fileLocation = System.getProperty("JavaScriptFileLocation");
			} else {
				fileLocation = "C:\\DATA\\Work\\Scripts\\";
			}
			System.out.println("Going to execute JavaScript");
			scriptEngine.eval(new FileReader(new File(fileLocation.concat(scriptStep.getFileName()))));
			System.out.println("JavaScript is exected");
		} catch (ScriptException scriptException) {
			throw new CWMSServiceException("Error executing script", scriptException);
		} catch (FileNotFoundException fileNotFoundException) {
			throw new CWMSServiceException("Error executing script", fileNotFoundException);
		}
		if(stepInstance != null) {
			stepInstance.setStepState(InstanceState.FINISHED);
			StepInstanceCache.getInstance().put(stepInstance.getId(), stepInstance);
		}
		System.out.println("Returning next");
		return NextState.RUN;
	}

}
