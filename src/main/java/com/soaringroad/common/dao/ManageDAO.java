package com.soaringroad.common.dao;

import java.io.Serializable;

import com.soaringroad.common.entity.CommonEntity;
/**
 * <pre>
 * Interface which defines management-related methods
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface ManageDAO<T extends CommonEntity, E extends Serializable> extends BaseDAO<T,E>{

    T update(T entity);

    T create(T entity);

    T delete(E id);
    
    void expire(E id, Long time);
}
