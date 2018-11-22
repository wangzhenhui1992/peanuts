package com.peanuts.community.data.entity;

import com.peanuts.community.common.vo.EntityTypeEnum;

/**
 * <pre>
 * Base interface of entities of ElasticSearch
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
public interface ElasticSearchEntity extends Entity {

    /**
     * define the entity type with {@link EntityTypeEnum#ELASTICSEARCH}
     * @see com.peanuts.community.data.entity.Entity#entityType()
     * 
     * @return {@link EntityTypeEnum.ELASTICSEARCH}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.ELASTICSEARCH;
    }
}
