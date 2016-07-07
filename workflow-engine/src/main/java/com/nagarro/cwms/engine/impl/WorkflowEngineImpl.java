package com.nagarro.cwms.engine.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagarro.cwms.cache.StepInstanceCache;
import com.nagarro.cwms.cache.WorkflowInstanceCache;
import com.nagarro.cwms.engine.StepExecutionService;
import com.nagarro.cwms.engine.StepExecutionServiceFactory;
import com.nagarro.cwms.engine.WorkflowEngine;
import com.nagarro.cwms.exception.CWMSException;
import com.nagarro.cwms.exception.CWMSServiceException;
import com.nagarro.cwms.execution.message.model.WorkflowMessage;
import com.nagarro.cwms.execution.model.ExecutionContext;
import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.NextState;
import com.nagarro.cwms.execution.model.WorkflowInstance;
import com.nagarro.cwms.model.Step;
import com.nagarro.cwms.model.WorkflowDefinition;
import com.nagarro.cwms.service.WorkflowManager;

/**
 * Service class to handle the workflow instances.
 * 
 * @author himanshu.kapoor
 * 
 */
@Stateless
public class WorkflowEngineImpl implements WorkflowEngine {
    
    private static final Logger LOG = LoggerFactory.getLogger(WorkflowEngineImpl.class);
    
    @EJB
    private WorkflowManager workflowManager;

    @EJB
    private StepExecutionServiceFactory stepExecutionServiceFactory;


    public void execute(WorkflowMessage message) throws CWMSException {

        if (message == null) {
            throw new CWMSServiceException("Workflow is invalid");
        }
        WorkflowInstance workflowInstance = null;
        try {
            WorkflowDefinition workflowDefinition = workflowManager.getWorkflowDefinitionById(message.getWorkflowId());
            if (message.getWorkflowInstanceId() != null) {
                workflowInstance = WorkflowInstanceCache.getInstance().getInstanceStateHealth(message.getWorkflowId(),
                        message.getWorkflowInstanceId());
            } else {
                workflowInstance = workflowManager.createWorkflowInstance(workflowDefinition);
                WorkflowInstanceCache.getInstance().put(workflowInstance.getWorkflow().getId(), workflowInstance.getId(), workflowInstance);
            }
            if (message.getStepInstanceId() != null) {
                StepInstanceCache.getInstance().get(message.getStepInstanceId()).setStepState(InstanceState.FINISHED);
            }
            NextState nextState = null;
            if (workflowInstance.getWorkflow().getSteps() != null && !workflowInstance.getWorkflow().getSteps().isEmpty()) {
                for (int i = 0; i < workflowInstance.getWorkflow().getSteps().size(); i++) {
                    Step step = workflowInstance.getWorkflow().getSteps().get(i);
                    if (workflowInstance.getExecutedStep() == null
                            || (workflowInstance.getExecutedStep() != null && !workflowInstance.getExecutedStep().contains(step))) {
                        StepExecutionService stepExecutionService = stepExecutionServiceFactory.getStepExecutionService(step);
                        ExecutionContext executionContext = new ExecutionContext();
                        if (workflowInstance.getExecutedStep() != null) {
                            workflowInstance.getExecutedStep().add(step);
                        } else {
                            List<Step> executedStep = new ArrayList<Step>();
                            executedStep.add(step);
                            workflowInstance.setExecutedStep(executedStep);
                        }

                        nextState = stepExecutionService.executeStep(executionContext, step, workflowInstance);
                        if (nextState == NextState.BLOCKED) {
                            break;
                        }
                    }
                    if (i == workflowInstance.getWorkflow().getSteps().size() - 1) {
                        nextState = NextState.RUN;
                    }
                }
            }

            if (nextState != null && NextState.RUN == nextState) {
                workflowInstance.setWorkflowState(InstanceState.FINISHED);
            } else {
                workflowInstance.setWorkflowState(InstanceState.BLOCKED);
            }
        } catch (Exception exception) {
            if (workflowInstance != null) {
                workflowInstance.setWorkflowState(InstanceState.BLOCKED);
            }
            LOG.error("Error occured while processing workflow", exception);
        }
        if (workflowInstance != null) {
            WorkflowInstanceCache.getInstance().put(workflowInstance.getWorkflow().getId(), workflowInstance.getId(), workflowInstance);
        }

    }

}
