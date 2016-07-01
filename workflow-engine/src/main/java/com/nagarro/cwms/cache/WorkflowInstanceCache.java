package com.nagarro.cwms.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.InstanceState;

/**
 * Temporary cache to hold the workflow Instance status.
 * In long run it would be replaced by EhCache.
 *
 */
public class WorkflowInstanceCache {
	
	public static WorkflowInstanceCache INSTACE = new WorkflowInstanceCache();
	
	private WorkflowInstanceCache() {
		
	}
	
	private Map<Long, InstanceState> cache = new ConcurrentHashMap<Long, InstanceState>();
	
	public void put(Long id, InstanceState instanceState) {
		if(cache.containsKey(id)) {
			cache.replace(id, instanceState);
		} else {
			cache.put(id, instanceState);
		}
	}
	
	public void remove(Long id) {
		if(cache.containsKey(id)) {
			cache.remove(id);
		}
	}
	
	public static WorkflowInstanceCache getInstance() {
		return INSTACE;
	}
}
