package com.soaringroad.peanuts.repository;

import com.soaringroad.data.redis.AbstractRedisRepository;
import com.soaringroad.peanuts.entity.JwtToken;
import com.soaringroad.peanuts.entity.User;

/**
 * <pre>
 * Redis Repository for user
 * TODO add hash before get
 * get(key) -> get(hash(key)).get(key)
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/21
 */
public class JwtTokenRepository extends AbstractRedisRepository<JwtToken, String> {

    @Override
    protected String entityName() {
        return User.ENTITY_NAME;
    }
}
