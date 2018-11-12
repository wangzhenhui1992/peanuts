package com.peanuts.community.data.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public interface CommonEntity extends ElasticSearchEntity, RdbEntity, RedisEntity {

    /**
     * <pre>
     * @see com.peanuts.community.data.entity.ElasticSearchEntity#entityType()
     * </pre>
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.COMMON;
    }
}
