package com.soaringroad.common.dao;

import java.io.Serializable;
import java.util.List;

import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.query.Query;

/**
 * <pre>
 * Interface which defines get-related methods
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface BrowseDAO<T extends CommonEntity, E extends Serializable> extends BaseDAO<T,E>{

    T get(E id);

    List<T> findAllById(List<E> ids);

    List<T> findAll();
    
    List<T> search(Query queryEntity);
    
    T aggregate(T entity);
}
