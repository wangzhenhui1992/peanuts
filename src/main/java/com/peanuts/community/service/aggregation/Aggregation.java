package com.peanuts.community.service.aggregation;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;

public interface Aggregation<T extends CommonEntity, E extends Serializable> {

    T aggregate(T e);
}
