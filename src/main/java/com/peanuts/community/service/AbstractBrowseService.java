package com.peanuts.community.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.common.CommonUtils;
import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.service.strategy.Aggregation;

/**
 * <pre>
 * Abstract class of {@link BrowseService}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public abstract class AbstractBrowseService<T extends CommonEntity, E extends Serializable>
        extends BasicService<T,E> implements BrowseService<T, E> {
    
    @Autowired
    private Aggregation<T,E> aggregation;

    @Override
    public final T get(E id) {
        // TODO Cache handle
        // TODO ES handle
        T entity = doGet(id);
        return aggregate(entity);
    }

    @Override
    public final List<T> findAllById(List<E> ids) {
        // TODO Cache handle
        // TODO ES handle
        List<T> entities = doFindAllById(ids);
        return aggregate(entities);
    }

    @Override
    public final List<T> findAll() {
        // TODO Cache handle
        // TODO ES handle
        List<T> entities = doFindAll();
        return aggregate(entities);
    }

    protected T doGet(E id) {
        return this.getRdbRepository().getOne(id);
    }


    protected List<T> doFindAllById(List<E> ids) {
        return this.getRdbRepository().findAllById(ids);
    }

    protected List<T> doFindAll() {
        return this.getRdbRepository().findAll();
    }

    @Override
    public final T aggregate(T entity) {
        return entity == null ? null : this.aggregation.aggregate(entity);
    }
    
    private final List<T> aggregate(List<T> entities) {
        if (CommonUtils.isCollectionEmpty(entities)) {
            return null;
        }
        return entities.stream().map(this::aggregate).collect(Collectors.toList());
    }
}
