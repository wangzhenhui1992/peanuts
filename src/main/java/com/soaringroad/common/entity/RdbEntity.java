package com.soaringroad.common.entity;

import com.soaringroad.common.vo.EntityTypeEnum;

/**
 * <pre>
 * Interface of entities of RDB
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
public interface RdbEntity extends Entity {

    /**
     * define the entity type with {@link EntityTypeEnum#RDB}
     * 
     * @see com.soaringroad.common.entity.Entity#entityType()
     * @return {@link EntityTypeEnum.RDB}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.RDB;
    }
}
