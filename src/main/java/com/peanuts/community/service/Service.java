package com.peanuts.community.service;

import java.io.Serializable;

import com.peanuts.community.data.entity.CommonEntity;
import com.peanuts.community.data.repository.ElasticSearchRepository;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.RedisRepository;
/**
 * <pre>
 * Interface which defines function of getting repositories 
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface Service<T extends CommonEntity, E extends Serializable> {
    RdbRepository<T,E> getRdbRepository();
    RedisRepository<T,E> getRedisRepository();
    ElasticSearchRepository<T,E> getEsRepository();
}
