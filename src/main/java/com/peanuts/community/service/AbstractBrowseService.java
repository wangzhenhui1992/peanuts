package com.peanuts.community.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.common.util.CommonUtils;
import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.data.query.Query;
import com.peanuts.community.service.aggregation.Aggregation;

/**
 * <pre>
 * Abstract class of {@link BrowseService}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public abstract class AbstractBrowseService<T extends CommonEntity, E extends Serializable> extends BasicServiceImpl<T, E>
        implements BrowseService<T, E> {

    @Autowired
    private Aggregation<T, E> aggregation;

    @Override
    public final T get(E id) {
        T entity = doGet(id);
        return aggregate(entity);
    }

    @Override
    public final List<T> findAllById(List<E> ids) {
        List<T> entities = doFindAllById(ids);
        return aggregate(entities);
    }

    @Override
    public final List<T> findAll() {
        List<T> entities = doFindAll();
        return aggregate(entities);
    }

    @Override
    public final List<T> search(Query query) {
        List<T> entities = this.getEsRepository() == null ? this.getRdbRepository().search(query)
                : this.getEsRepository().search(query);
        return aggregate(entities);
    }

    protected T doGet(E id) {
        return Optional.ofNullable(doGetFromRedis(id)).orElse(doGetFromRdb(id));
    }

    protected T doGetFromRedis(E id) {
        return Optional.ofNullable(this.getRedisRepository()).map(redisRepo -> redisRepo.getValue(id)).orElse(null);
    }

    protected T doGetFromRdb(E id) {
        T entity = this.getRdbRepository().getOne(id);
        Optional.ofNullable(entity).ifPresent(t -> doUpdateToRedis(id, t));
        return entity;
    }

    protected void doUpdateToRedis(E id, T entity) {
        Optional.ofNullable(this.getRedisRepository())
                .ifPresent(redisRepository -> redisRepository.setValue(id, entity));
    }

    protected List<T> doFindAllById(List<E> ids) {
        return this.getRdbRepository().findAllById(ids);
    }

    protected List<T> doFindAll() {
        return this.getRdbRepository().findAll();
    }

    @Override
    public final T aggregate(T entity) {
        return Optional.ofNullable(entity).map(t -> this.aggregation.aggregate(t)).orElseGet(null);
    }

    private final List<T> aggregate(List<T> entities) {
        if (CommonUtils.isCollectionEmpty(entities)) {
            return null;
        }
        return entities.stream().map(this::aggregate).collect(Collectors.toList());
    }
}
