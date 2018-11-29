package com.soaringroad.common.vo;

import java.io.Serializable;

/**
 * <pre>
 * Interface of all enums
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
public interface Enum extends Serializable {

    /**
     * Code
     * 
     * @return code
     */
    int getCode();

    /**
     * Name
     * 
     * @return name
     */
    String getName();
}
