package com.soaringroad.data.rdb;

import java.util.List;

import com.soaringroad.data.query.Query;

public interface RdbSearchable<T> {

    List<T> search(Query entity);
}
