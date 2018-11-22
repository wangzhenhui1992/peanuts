package com.peanuts.community.data.entity;

import com.peanuts.community.common.vo.EntityTypeEnum;

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
     * @see com.peanuts.community.data.entity.Entity#entityType()
     * @return {@link EntityTypeEnum.RDB}
     */
    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.RDB;
    }
}
