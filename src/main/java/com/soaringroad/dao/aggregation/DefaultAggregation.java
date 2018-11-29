package com.soaringroad.dao.aggregation;

import java.io.Serializable;

import com.soaringroad.common.dao.Aggregation;
import com.soaringroad.common.entity.CommonEntity;

/**
 * <pre>
 * Default aggregation
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class DefaultAggregation<T extends CommonEntity, E extends Serializable> implements Aggregation<T,E>{

    @Override
    public T aggregate(T e) {
        return e;
    }

}
