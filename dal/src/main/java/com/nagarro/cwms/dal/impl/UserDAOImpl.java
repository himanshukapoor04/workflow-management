package com.nagarro.cwms.dal.impl;

import javax.ejb.Stateless;

import com.nagarro.cwms.cache.UserInstanceCache;
import com.nagarro.cwms.dal.UserDAO;
import com.nagarro.cwms.model.User;

/**
 * Implementation class for UserDAO operations.
 * 
 */
@Stateless
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

    @Override
    public void clearUserStepsToApprove(Long userId) {
        UserInstanceCache.getInstance().get(userId).getStepsToApprove().clear();
    }
}
