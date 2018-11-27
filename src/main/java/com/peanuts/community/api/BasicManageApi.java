package com.peanuts.community.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.service.ManageService;
/**
 * <pre>
 * Basic api providing manage functions as well as browse functions
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public class BasicManageApi<T extends CommonEntity, E extends Serializable> extends BasicBrowseApi<T,E>{
    
    public BasicManageApi() {}
    
    @Autowired
    private ManageService<T,E> service;

    @Override
    protected T doPost(T entity) {
        return this.service.create(entity);
    }

    @Override
    protected T doPut(T entity) {
        return this.service.update(entity);
    }

    @Override
    protected T doDelete(E id) {
        return this.service.delete(id);
    }
}
