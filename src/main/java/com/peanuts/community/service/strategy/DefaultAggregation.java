package com.peanuts.community.service.strategy;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;

public class DefaultAggregation<T extends CommonEntity, E extends Serializable> implements Aggregation<T,E>{

    @Override
    public T aggregate(T e) {
        return e;
    }

}
