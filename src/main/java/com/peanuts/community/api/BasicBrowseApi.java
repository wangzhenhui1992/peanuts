package com.peanuts.community.api;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.data.query.Query;
import com.peanuts.community.service.BrowseService;

/**
 * <pre>
 * Basic api providing browse functions
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public class BasicBrowseApi<T extends CommonEntity, E extends Serializable> extends AbstractBaseApi<T, E> {

    @Autowired
    private BrowseService<T, E> service;

    public BasicBrowseApi() {
        this.denyDelete();
        this.denyPost();
        this.denyPut();
    }

    @Override
    protected T doGet(E id) {
        return service.get(id);
    }

    @Override
    protected List<T> doSearch(Query query) {
        return service.search(query);
    }

    @Override
    protected T doPost(T entity) {
        return null;
    }

    @Override
    protected T doPut(T entity) {
        return null;
    }

    @Override
    protected T doDelete(E id) {
        return null;
    }

}
