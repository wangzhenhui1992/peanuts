package com.soaringroad.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.soaringroad.common.dao.ManageDAO;
import com.soaringroad.common.entity.CommonEntity;
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
    private ManageDAO<T,E> service;

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
