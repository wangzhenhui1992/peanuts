package com.soaringroad.common.entity;

import com.soaringroad.common.vo.EntityTypeEnum;

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
     * @see com.soaringroad.common.entity.Entity#entityType()
     * 
     * @return {@link EntityTypeEnum.ELASTICSEARCH}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.ELASTICSEARCH;
    }
}
