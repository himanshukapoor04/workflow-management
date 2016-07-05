package com.nagarro.cwms.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.InstanceState;

/**
 * Temporary cache to hold the workflow Instance status.
 * In long run it would be replaced by Infinispan.
 *
 */
public class WorkflowInstanceCache {
	
	private static WorkflowInstanceCache INSTACE = new WorkflowInstanceCache();
	
	private WorkflowInstanceCache() {
		
	}
	
	private Map<Long, Map<Long,InstanceState>> cache = new ConcurrentHashMap<>();
	
	public synchronized void put(Long workflowId, Long instanceId, InstanceState instanceState) {
		if(cache.containsKey(workflowId)) {
			cache.get(workflowId).put(instanceId, instanceState);
		} else {
			Map<Long, InstanceState> instanceMap = new ConcurrentHashMap<Long, InstanceState>();
			instanceMap.put(instanceId, instanceState);
			cache.put(workflowId,instanceMap);
		}
	}
	
	public synchronized void removeInstance(Long workflowId, Long instanceId) {
		if(cache.containsKey(workflowId)) {
			cache.get(workflowId).remove(instanceId);
		}
	}
	
	public Map<Long, InstanceState> getAllByWorkflowId(Long workflowId) {
		return cache.get(workflowId);
	}
	
	public InstanceState getInstanceStateHealth(Long workFlowId, Long instanceId) {
		InstanceState instanceState = null;
		Map<Long , InstanceState> healthMap = cache.get(workFlowId);
		if(healthMap != null) {
			instanceState = healthMap.get(instanceId);
		} 
		return instanceState;
	}
	
	public static WorkflowInstanceCache getInstance() {
		return INSTACE;
	}
}
