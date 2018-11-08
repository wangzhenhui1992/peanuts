package com.peanuts.community.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.data.repository.ElasticSearchRepository;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.RedisRepository;

/**
 * <pre>
 * Implementation of {@link Service}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public class BasicService<T extends CommonEntity, E extends Serializable> implements Service<T, E> {

    @Autowired
    private RdbRepository<T, E> rdbRepository;

    @Override
    public final RdbRepository<T, E> getRdbRepository() {
        return this.rdbRepository;
    }

    @Override
    public final RedisRepository<T, E> getRedisRepository() {
        // TODO
        return null;
    }

    @Override
    public final ElasticSearchRepository<T, E> getEsRepository() {
        // TODO
        return null;
    }
}
