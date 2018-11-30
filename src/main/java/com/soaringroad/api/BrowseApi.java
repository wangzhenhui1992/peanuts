package com.soaringroad.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.soaringroad.common.entity.Entity;
import com.soaringroad.common.query.Query;

/**
 * <pre>
 * Interfaces define browse methods for api
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public interface BrowseApi<T extends Entity, E extends Serializable> {

    /**
     * Get entity by id
     * @param id
     * @return
     */
    ResponseEntity<T> get(E id);
    
    /**
     * Search entities by query
     * 
     * @param query
     * @return
     */
    ResponseEntity<List<T>> search(Query query);
}
