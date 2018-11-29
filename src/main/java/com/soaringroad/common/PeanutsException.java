package com.soaringroad.common;

/**
 * <pre>
 * Exception
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/09
 */
public class PeanutsException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 9095570957366348612L;

    public PeanutsException(String message) {
        super(message);
    }
    
    public PeanutsException(Throwable t) {
        super(t);
    }

    public PeanutsException(String message, Throwable t) {
        super(message, t);
    }

}
