package com.nagarro.cwms.helper;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.cwms.model.ScriptStep;
import com.nagarro.cwms.model.Step;

public class WorkflowManagerHelper {
	
	public static List<Step> getSteps() {
		ScriptStep scriptStep = new ScriptStep();
		scriptStep.setDescription("Sample Script");
		scriptStep.setId(new Long(1));
		scriptStep.setFileName("Script.js");
		scriptStep.setName("Sample Script");
		List<Step> steps = new ArrayList<Step>();
		steps.add(scriptStep);
		return steps;
	}
}
