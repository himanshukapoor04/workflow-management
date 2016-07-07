package com.nagarro.cwms.dal;

import javax.ejb.Local;

import com.nagarro.cwms.model.User;

/**
 * DAO class for user related operations. 
 *
 */
@Local
public interface UserDAO extends BaseDAO<User, Long> {
	
    /**
     * Clear all the steps which needs to be approved by the user.
     * @param userId for which steps needs to be approved.
     */
	void clearUserStepsToApprove(Long userId);
}
