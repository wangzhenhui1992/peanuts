package com.peanuts.community.data.repository;

import java.io.Serializable;
import java.util.List;

import com.peanuts.community.data.entity.RedisEntity;

/**
 * Base interface of Redis repository
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
public interface RedisRepository<T extends RedisEntity, E extends Serializable> extends Repository<T, E> {

    /**
     * Get by id
     * 
     * @param id id
     * @return value
     */
    T getValue(E id);

    /**
     * Save
     * 
     * @param id     id
     * @param entity target to save
     * @return target
     */
    T setValue(E id, T entity);

    /**
     * Get by multiply ids
     * 
     * @param ids
     * @return
     */
    List<T> getMultiValue(List<E> ids);

    /**
     * Increase value.
     * 
     * @param id    id
     * @param delta delta(double)
     * @return value(double) after increasing
     */
    Double increaseValue(E id, double delta);

    /**
     * Increase value.
     * 
     * @param id    id
     * @param delta delta(long)
     * @return value(long) after increasing
     */
    Long increaseValue(E id, long delta);

    /**
     * Delete by id
     * 
     * @param id id
     */
    void delete(E id);

    /**
     * Set timeout
     * 
     * @param id      id
     * @param seconds seconds
     */
    void expire(E id, long seconds);
}
