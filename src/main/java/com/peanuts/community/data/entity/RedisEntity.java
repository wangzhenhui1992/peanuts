package com.peanuts.community.data.entity;

import com.peanuts.community.common.vo.EntityTypeEnum;

/**
 * <pre>
 * Interface of entities of Redis
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
public interface RedisEntity extends Entity {

    /**
     * define the entity type with {@link EntityTypeEnum#REDIS}
     * 
     * @see com.peanuts.community.data.entity.Entity#entityType()
     * @return {@link EntityTypeEnum#REDIS}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.REDIS;
    }
}
