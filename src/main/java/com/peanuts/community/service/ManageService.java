package com.peanuts.community.service;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;
/**
 * <pre>
 * Interface which defines management-related methods
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface ManageService<T extends CommonEntity, E extends Serializable> extends Service<T,E>{

    T update(T entity);

    T create(T entity);

    void delete(E id);
}
