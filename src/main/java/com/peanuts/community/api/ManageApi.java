package com.peanuts.community.api;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.peanuts.community.data.entity.Entity;

/**
 * <pre>
 * Interfaces define manage methods for api
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public interface ManageApi<T extends Entity, E extends Serializable> {

    /**
     * Update entity
     * @param entity
     * @return
     */
    ResponseEntity<T> put(T entity);

    /**
     * Create entity
     * @param entity
     * @return
     */
    ResponseEntity<T> post(T entity);

    /**
     * Delete entity
     * @param entity
     * @return
     */
    ResponseEntity<T> delete(E id);
}
