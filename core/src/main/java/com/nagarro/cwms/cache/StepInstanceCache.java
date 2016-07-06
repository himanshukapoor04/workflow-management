package com.nagarro.cwms.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.execution.model.StepInstance;

/**
 * Temporary cache to hold the Workflow step Instance status.
 * In long run it would be replaced by Infinispan.
 *
 */
public class StepInstanceCache {
	
	private static StepInstanceCache INSTACE = new StepInstanceCache();
	
	private StepInstanceCache() {
		
	}
	
	private Map<Long, StepInstance> cache = new ConcurrentHashMap<Long, StepInstance>();
	
	public synchronized void put(Long id, StepInstance stepInstance) {
		if(cache.containsKey(id)) {
			cache.remove(id);
			cache.put(id, stepInstance);
		} else {
			cache.put(id, stepInstance);
		}
	}
	
	public synchronized void remove(Long id) {
		if(cache.containsKey(id)) {
			cache.remove(id);
		}
	}
	
	public StepInstance get(Long id) {
		return cache.get(id);
	}
	
	public static StepInstanceCache getInstance() {
		return INSTACE;
	}
}
