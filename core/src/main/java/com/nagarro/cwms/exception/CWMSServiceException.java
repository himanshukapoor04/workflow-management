package com.nagarro.cwms.exception;

import javax.ejb.ApplicationException;

/**
 * Exception class for service layer. If this exception will be thrown then transaction will be roll back.
 * 
 */
@ApplicationException(rollback = true)
public class CWMSServiceException extends CWMSException {

    private static final long serialVersionUID = 6868716434958110442L;


    public CWMSServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    public CWMSServiceException(String message) {
        super(message);
    }

}
