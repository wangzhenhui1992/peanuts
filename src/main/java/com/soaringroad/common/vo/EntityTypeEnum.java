package com.soaringroad.common.vo;

import lombok.AllArgsConstructor;

/**
 * <pre>
 * Enum of entity type
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum EntityTypeEnum implements Enum {

    /**
     * Common Entity
     */
    COMMON(0),
    /**
     * RDB Entity
     */
    RDB(1),
    /**
     * Redis Entity
     */
    REDIS(2),
    /**
     * ES Entity
     */
    ELASTICSEARCH(3);

    private int code;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name();
    }
}
