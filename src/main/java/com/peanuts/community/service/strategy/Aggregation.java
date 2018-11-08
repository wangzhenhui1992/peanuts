package com.peanuts.community.service.strategy;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;

public interface Aggregation<T extends CommonEntity, E extends Serializable> {

    T aggregate(T e);
}
