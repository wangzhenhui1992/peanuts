package com.peanuts.community.data.entity;

import java.io.Serializable;

import com.peanuts.community.common.vo.EntityTypeEnum;

/**
 * <pre>
 * Interface of all entities
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/10/30
 */
public interface Entity extends Serializable {
    
    /**
     * Entity name
     * @return Name of entity
     */
    String entityName();

    /**
     * Entity Type
     * @return Type of entity
     */
    EntityTypeEnum entityType();
}
