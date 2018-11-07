package com.peanuts.community.service;

import java.io.Serializable;
import java.util.List;

import com.peanuts.community.data.entity.RdbEntity;
import com.peanuts.community.data.repository.RdbRepository;
/**
 * <pre>
 * Abstract Class of Service
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
public abstract class AbstractService<T extends RdbEntity, E extends Serializable> implements CrudService<T, E> {

    @Override
    public final T get(E id) {
        // TODO Cache handle
        T entity = doGet(id);
        return entity;
    }

    @Override
    public final T update(T entity) {
        // TODO Cache handle
        T entityUpd = doUpdate(entity);
        return entityUpd;
    }

    @Override
    public final T create(T entity) {
        // TODO Cache handle
        T entityCrt = doUpdate(entity);
        return entityCrt;
    }

    @Override
    public final void delete(E id) {
        // TODO Cache handle
        doDelete(id);
    }
    
    @Override
    public final List<T> findAllById(List<E> ids) {
        return doFindAllById(ids);
    }

    protected T doGet(E id) {
        return repository().getOne(id);
    }

    protected T doUpdate(T entity) {
        return repository().save(entity);
    }

    protected T doCreate(T entity) {
        return repository().save(entity);
    }

    protected void doDelete(E id) {
        repository().deleteById(id);
    }
    
    protected List<T> doFindAllById(List<E> ids) {
        return repository().findAllById(ids);
    }
    
    protected T aggregate(T entity) {
        return entity;
    }
    
    protected abstract RdbRepository<T,E> repository() ;

}
