package com.peanuts.community.service;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;

/**
 * <pre>
 * Abstract class of {@link ManageService} and extends {@link AbstractBrowseService}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
public abstract class AbstractManageService<T extends CommonEntity, E extends Serializable>
        extends AbstractBrowseService<T, E> implements ManageService<T, E> {

    @Override
    public final T update(T entity) {
        // TODO Cache handle
        // TODO ES handle
        T entityUpd = doUpdate(entity);
        return aggregate(entityUpd);
    }

    @Override
    public final T create(T entity) {
        // TODO Cache handle
        // TODO ES handle
        T entityCrt = doUpdate(entity);
        return aggregate(entityCrt);
    }

    @Override
    public final void delete(E id) {
        // TODO Cache handle
        // TODO ES handle
        doDelete(id);
    }

    protected T doUpdate(T entity) {
        return this.getRdbRepository().save(entity);
    }

    protected T doCreate(T entity) {
        return this.getRdbRepository().save(entity);
    }

    protected void doDelete(E id) {
        this.getRdbRepository().deleteById(id);
    }

}
