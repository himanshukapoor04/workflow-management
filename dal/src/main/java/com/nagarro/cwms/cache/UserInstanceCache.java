package com.nagarro.cwms.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.cwms.model.User;

public class UserInstanceCache {
    private static UserInstanceCache INSTACE = new UserInstanceCache();


    private UserInstanceCache() {

    }

    private Map<Long, User> cache = new ConcurrentHashMap<Long, User>();


    public synchronized void put(Long id, User user) {
        if (cache.containsKey(id)) {
            cache.remove(id);
            cache.put(id, user);
        } else {
            cache.put(id, user);
        }
    }


    public synchronized void remove(Long id) {
        if (cache.containsKey(id)) {
            cache.remove(id);
        }
    }


    public User get(Long id) {
        return cache.get(id);
    }


    public static UserInstanceCache getInstance() {
        return INSTACE;
    }
}
