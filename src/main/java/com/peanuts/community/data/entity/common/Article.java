package com.peanuts.community.data.entity.common;

import com.peanuts.community.data.entity.CommonEntity;

/**
 * <pre>
 * Article
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
public class Article implements CommonEntity {

    private static final String ENTITY_NAME = "article";

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
}
