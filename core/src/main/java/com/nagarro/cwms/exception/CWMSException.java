package com.nagarro.cwms.exception;

/**
 * Parent exception class. Every exception class will inherit this exception.
 * 
 */
public class CWMSException extends Exception {

    /** Generated Serial Version Id */
    private static final long serialVersionUID = -7671212596795558759L;


    public CWMSException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }


    public CWMSException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
