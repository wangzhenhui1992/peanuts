package com.soaringroad.api.validator;

import java.io.Serializable;

import com.soaringroad.common.entity.Entity;
import com.soaringroad.data.query.Query;

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
