package com.soaringroad.dao;

import java.io.Serializable;
import java.util.Optional;

import com.soaringroad.common.dao.ManageDAO;
import com.soaringroad.common.entity.CommonEntity;

/**
 * <pre>
 * Abstract class of {@link ManageDAO} and extends {@link BasicBrowseDAO}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
public class BasicManageDAO<T extends CommonEntity, E extends Serializable>
        extends BasicBrowseDAO<T, E> implements ManageDAO<T, E> {

    @Override
    public final T update(T entity) {
        T entityUpd = doUpdate(entity);
        return aggregate(entityUpd);
    }

    @Override
    public final T create(T entity) {
        T entityCrt = doUpdate(entity);
        return aggregate(entityCrt);
    }
    
    @Override
    public final T delete(E id) {
        doDelete(id);
        return this.get(id);
    }

    protected T doUpdate(T entity) {
        T result = this.doUpdateToRdb(entity);
        this.doUpdateToRedis(entity.getId(), entity);
        this.doUpdateToEs(entity);
        return result;
    }
    
    protected T doUpdateToRdb(T entity) {
        return this.getRdbRepository().save(entity);
    }
    
    protected T doUpdateToEs(T entity) {
        return Optional.ofNullable(this.getEsRepository()).map(esRepo->esRepo.index(entity)).orElse(null);
    }

    protected void doDelete(E id) {
        this.getRdbRepository().deleteById(id);
    }
    
    protected void doDeleteToRedis(E id) {
        Optional.ofNullable(this.getRedisRepository()).ifPresent(redisRepo->redisRepo.delete(id));
    }
    
    protected void doDeleteToEs(E id) {
        Optional.ofNullable(this.getEsRepository()).ifPresent(esRepo->esRepo.delete(id));
    }

}
