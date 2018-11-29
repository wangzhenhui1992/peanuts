package com.soaringroad.common.dao;

import java.io.Serializable;

import com.soaringroad.common.entity.Entity;

/**
 * <pre>
 * Aggregation
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public interface Aggregation<T extends Entity, E extends Serializable> {

    T aggregate(T e);
}
