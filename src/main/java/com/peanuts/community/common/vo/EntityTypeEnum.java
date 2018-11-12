package com.peanuts.community.common.vo;

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
    COMMON(0, "COMMON"),
    /**
     * RDB Entity
     */
    RDB(1, "RDB"),
    /**
     * Redis Entity
     */
    REDIS(2, "REDIS"),
    /**
     * ES Entity
     */
    ELASTICSEARCH(3, "ELASTICSEARCH");

    private int code;
    private String name;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
