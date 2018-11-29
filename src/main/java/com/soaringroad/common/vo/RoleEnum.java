package com.soaringroad.common.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum RoleEnum implements Enum {
    /**
     * Anonymous
     */
    ANONYMOUS(0),
    /**
     * User
     */
    USER(1),
    /**
     * Administrator
     */
    ADMINISTRATOR(2),
    /**
     * Root
     */
    ROOT(3);
    
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
