package com.peanuts.community.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.peanuts.community.common.vo.EntityTypeEnum;

/**
 * <pre>
 * Interface of entities of common field
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public interface CommonEntity extends ElasticSearchEntity, RdbEntity, RedisEntity {

    /**
     * define the entity type with {@link EntityTypeEnum#COMMON}
     * 
     * @see com.peanuts.community.data.entity.Entity#entityType()
     * 
     * @return {@link EntityTypeEnum.COMMON}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.COMMON;
    }
}
