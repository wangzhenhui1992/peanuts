package com.soaringroad.peanuts.entity;

import java.io.Serializable;

import com.soaringroad.common.entity.RedisEntity;

import lombok.Data;

/**
 * <pre>
 * Entity of JWT token
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/12/03
 */
@Data
public class JwtToken implements RedisEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 3933661620268257119L;

    private static final String ENTITY_NAME = "jwt-token";
    private String token;
    private User user;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends Serializable> E getId() {
        return (E) token;
    }

}
