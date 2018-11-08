package com.peanuts.community.service;

import java.io.Serializable;
import java.util.List;

import com.peanuts.community.data.entity.RdbEntity;

public interface CrudService<T extends RdbEntity, E extends Serializable> {

    T get(E id);

    T update(T entity);

    T create(T entity);

    void delete(E id);
    
    List<T> findAllById(List<E> ids);
}
