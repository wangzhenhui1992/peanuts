package com.soaringroad.common.repository;

import java.io.Serializable;
import java.util.List;

import com.soaringroad.common.entity.ElasticSearchEntity;
import com.soaringroad.data.query.Query;

/**
 * <pre>
 * Base of ES repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
public interface ElasticSearchRepository<T extends ElasticSearchEntity, E extends Serializable>{
    
    /**
     * Index a document
     * @param entity target to index
     * @return the entity
     */
    <S extends T> S index(S entity);
    
    /**
     * Search
     * @param entity search options
     * @return result
     */
    List<T> search(Query entity);
    
    /**
     * Delete a document by id
     * @param id id
     */
    void delete(E id);
}
