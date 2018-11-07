package com.peanuts.community.common;

public class PeanutsException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 9095570957366348612L;

    public PeanutsException(String message) {
        super(message);
    }

    public PeanutsException(String message, Throwable t) {
        super(message, t);
    }

}
