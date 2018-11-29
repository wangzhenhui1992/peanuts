package com.soaringroad.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.soaringroad.common.dao.DAO;
import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.repository.ElasticSearchRepository;
import com.soaringroad.common.repository.RdbRepository;
import com.soaringroad.common.repository.RedisRepository;

/**
 * <pre>
 * Implementation of {@link DAO}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public class BasicDAO<T extends CommonEntity, E extends Serializable> implements DAO<T, E> {

    @Autowired
    private RdbRepository<T, E> rdbRepository;

    @Autowired(required = false)
    private ElasticSearchRepository<T, E> esRepository;

    @Autowired(required = false)
    private RedisRepository<T, E> redisRepository;

    @Override
    public final RdbRepository<T, E> getRdbRepository() {
        return this.rdbRepository;
    }

    @Override
    public final RedisRepository<T, E> getRedisRepository() {
        return this.redisRepository;
    }

    @Override
    public final ElasticSearchRepository<T, E> getEsRepository() {
        return this.esRepository;
    }
}
