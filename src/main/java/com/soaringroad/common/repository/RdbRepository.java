package com.soaringroad.common.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.soaringroad.common.entity.RdbEntity;
import com.soaringroad.data.Searchable;

/**
 * <pre>
 * Base of RDB repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@NoRepositoryBean
public interface RdbRepository<T extends RdbEntity, E extends Serializable>
        extends Repository<T, E>, JpaRepository<T, E>, Searchable<T> {
}
