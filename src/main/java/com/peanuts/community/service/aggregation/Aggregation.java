package com.peanuts.community.service.aggregation;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;

/**
 * <pre>
 * Aggregation
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public interface Aggregation<T extends CommonEntity, E extends Serializable> {

    T aggregate(T e);
}
