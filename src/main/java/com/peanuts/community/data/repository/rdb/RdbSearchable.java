package com.peanuts.community.data.repository.rdb;

import java.util.List;

import com.peanuts.community.data.query.Query;

public interface RdbSearchable<T> {

    List<T> search(Query entity);
}
