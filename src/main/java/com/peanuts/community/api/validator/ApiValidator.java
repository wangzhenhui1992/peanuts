package com.peanuts.community.api.validator;

import java.io.Serializable;

import com.peanuts.community.data.entity.Entity;
import com.peanuts.community.data.query.Query;

public interface ApiValidator<T extends Entity, E extends Serializable> {

    default boolean validateGet(E id) {
        return true;
    }

    default boolean validatePost(T entity) {
        return true;
    }

    default boolean validatePut(T entity) {
        return true;
    }

    default boolean validateDelete(E id) {
        return true;
    }

    default boolean validateSearch(Query query) {
        return true;
    }
}
