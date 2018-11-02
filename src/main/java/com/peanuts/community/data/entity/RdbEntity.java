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

    @Override
    default EntityTypeEnum entityType() {
        return EntityTypeEnum.RDB;
    }
}
