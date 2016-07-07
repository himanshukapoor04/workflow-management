package com.nagarro.cwms.exception;

/**
 * Exception class for the cases when entity is searched but not found in the database.
 * 
 */
public class CWMSEntityNotFoundException extends CWMSException {

    /** Default Serial Version Id */
    private static final long serialVersionUID = -4513176875615208597L;


    public CWMSEntityNotFoundException(String message) {
        super(message);
    }


    public CWMSEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
