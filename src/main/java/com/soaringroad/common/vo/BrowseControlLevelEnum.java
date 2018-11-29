package com.soaringroad.common.vo;

import lombok.AllArgsConstructor;

/**
 * <pre>
 * Browse Control Level Enum
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/12
 */
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum BrowseControlLevelEnum implements Enum {

    // LIST
    LIST(1),
    // VIEW
    VIEW(2),
    // MODIFY
    MODIFY(3),
    // SECRET
    SECRET(4);

    private int code;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return this.name();
    }

}
