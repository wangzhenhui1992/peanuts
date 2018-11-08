package com.peanuts.community.common;

import java.util.Collection;
/**
 * <pre>
 * Common Utilities
 * If this class is large enough, we should divide it into more classes.
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public class CommonUtils {

    private CommonUtils() {
    };

    /**
     * <pre>
     * Return true when {@code c} is null or has no elements.Otherwise return false. 
     * </pre>
     * @param c collection
     * @return true or false
     */
    public static final boolean isCollectionEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }
    
    /**
     * <pre>
     * Return true when {@code str} is null or empty.Otherwise return false. 
     * </pre>
     * @param str string
     * @return true or false
     */
    public static final boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    /**
     * <pre>
     * Return true when {@code str} is null or its length is 0 after {@link String#trim()}.Otherwise return false. 
     * </pre>
     * @param str string
     * @return true or false
     */
    public static final boolean isStringEmptyWithTrim(String str) {
        return isStringEmpty(str) || str.trim().isEmpty();
        
    }
}
