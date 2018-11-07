package com.peanuts.community.data.repository;

import java.io.Serializable;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.peanuts.community.data.entity.ElasticSearchEntity;

/**
 * <pre>
 * Base of ES repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@NoRepositoryBean
public interface ElasticSearchRepository<T extends ElasticSearchEntity, E extends Serializable>
        extends ElasticsearchRepository<T, E> {

}
