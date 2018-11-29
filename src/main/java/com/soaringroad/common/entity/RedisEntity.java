package com.soaringroad.common.entity;

import com.soaringroad.common.vo.EntityTypeEnum;

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
     * @see com.soaringroad.common.entity.Entity#entityType()
     * @return {@link EntityTypeEnum#REDIS}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.REDIS;
    }
}
