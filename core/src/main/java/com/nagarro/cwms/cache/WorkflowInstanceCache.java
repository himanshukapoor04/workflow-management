package com.nagarro.cwms.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.InstanceState;
import com.nagarro.cwms.execution.model.WorkflowInstance;

/**
 * Temporary cache to hold the workflow Instance status.
 * In long run it would be replaced by Infinispan.
 *
 */
public class WorkflowInstanceCache {
	
	private static WorkflowInstanceCache INSTACE = new WorkflowInstanceCache();
	
	private WorkflowInstanceCache() {
		
	}
	
	private Map<Long, Map<Long, WorkflowInstance>> cache = new ConcurrentHashMap<>();
	
	public synchronized void put(Long workflowId, Long instanceId, WorkflowInstance workflowInstance) {
		if(cache.containsKey(workflowId)) {
			cache.get(workflowId).put(instanceId, workflowInstance);
		} else {
			Map<Long, WorkflowInstance> instanceMap = new ConcurrentHashMap<>();
			instanceMap.put(instanceId, workflowInstance);
			cache.put(workflowId,instanceMap);
		}
	}
	
	public synchronized void removeInstance(Long workflowId, Long instanceId) {
		if(cache.containsKey(workflowId)) {
			cache.get(workflowId).remove(instanceId);
		}
	}
	
	public Map<Long, WorkflowInstance> getAllByWorkflowId(Long workflowId) {
		return cache.get(workflowId);
	}
	
	public WorkflowInstance getInstanceStateHealth(Long workFlowId, Long instanceId) {
		WorkflowInstance workflowInstance = null;
		Map<Long , WorkflowInstance> healthMap = cache.get(workFlowId);
		if(healthMap != null) {
			workflowInstance = healthMap.get(instanceId);
		} 
		return workflowInstance;
	}
	
	public static WorkflowInstanceCache getInstance() {
		return INSTACE;
	}
}
