package com.peanuts.community.common.vo;

import lombok.AllArgsConstructor;
/**
 * <pre>
 * Browse Control Level Enum
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/12
 */
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum BrowseControlLevelEnum implements Enum {

    // LIST
    LIST(1, "LIST"),
    // VIEW
    VIEW(2, "VIEW"),
    // ADMIN
    ADMIN(3, "ADMIN");

    private int code;
    private String name;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

}
