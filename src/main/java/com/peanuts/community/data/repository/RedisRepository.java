package com.peanuts.community.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.peanuts.community.data.entity.RedisEntity;

/**
 * Base interface of Redis repository
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@NoRepositoryBean
public interface RedisRepository<T extends RedisEntity, E extends Serializable> extends Repository<T, E> {
}
