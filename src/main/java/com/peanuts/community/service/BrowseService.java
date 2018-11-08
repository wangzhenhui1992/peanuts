package com.peanuts.community.service;

import java.io.Serializable;
import java.util.List;

import com.peanuts.community.data.entity.CommonEntity;

/**
 * <pre>
 * Interface which defines get-related methods
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface BrowseService<T extends CommonEntity, E extends Serializable> extends Service<T,E>{

    T get(E id);

    List<T> findAllById(List<E> ids);

    List<T> findAll();
    
    T aggregate(T entity);
}
