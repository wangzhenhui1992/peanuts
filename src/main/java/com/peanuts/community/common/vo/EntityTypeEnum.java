package com.peanuts.community.common.vo;

/**
 * <pre>
 * Enum of entity type
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
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

    private EntityTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
