package com.soaringroad.common.dao;

import java.io.Serializable;

import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.repository.ElasticSearchRepository;
import com.soaringroad.common.repository.RdbRepository;
import com.soaringroad.common.repository.RedisRepository;
/**
 * <pre>
 * Interface which defines function of getting repositories 
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
public interface DAO<T extends CommonEntity, E extends Serializable> {
    RdbRepository<T,E> getRdbRepository();
    RedisRepository<T,E> getRedisRepository();
    ElasticSearchRepository<T,E> getEsRepository();
}
