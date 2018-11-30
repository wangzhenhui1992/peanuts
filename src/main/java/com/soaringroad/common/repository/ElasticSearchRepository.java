package com.soaringroad.common.repository;

import java.io.Serializable;

import com.soaringroad.common.entity.ElasticSearchEntity;
import com.soaringroad.data.Searchable;

/**
 * <pre>
 * Base of ES repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
public interface ElasticSearchRepository<T extends ElasticSearchEntity, E extends Serializable> extends Searchable<T>{
    
    /**
     * Index a document
     * @param entity target to index
     * @return the entity
     */
    <S extends T> S index(S entity);
    
    /**
     * Delete a document by id
     * @param id id
     */
    void delete(E id);
}
