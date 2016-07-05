package com.nagarro.cwms.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.InstanceState;

/**
 * Temporary cache to hold the Workflow step Instance status.
 * In long run it would be replaced by Infinispan.
 *
 */
public class StepInstanceCache {
	
	private static StepInstanceCache INSTACE = new StepInstanceCache();
	
	private StepInstanceCache() {
		
	}
	
	private Map<Long, InstanceState> cache = new ConcurrentHashMap<Long, InstanceState>();
	
	public synchronized void put(Long id, InstanceState instanceState) {
		if(cache.containsKey(id)) {
			cache.remove(id);
			cache.put(id, instanceState);
		} else {
			cache.put(id, instanceState);
		}
	}
	
	public void remove(Long id) {
		if(cache.containsKey(id)) {
			cache.remove(id);
		}
	}
	
	public static StepInstanceCache getInstance() {
		return INSTACE;
	}
}
