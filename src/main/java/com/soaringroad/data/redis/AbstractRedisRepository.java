package com.soaringroad.data.redis;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.soaringroad.common.entity.RedisEntity;
import com.soaringroad.common.repository.RedisRepository;
import com.soaringroad.common.util.CommonUtils;

/**
 * <pre>
 * Abstract Redis Repository
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/21
 */
@Component
@ConditionalOnBean(RedisTemplate.class)
public abstract class AbstractRedisRepository<T extends RedisEntity, E extends Serializable>
        implements RedisRepository<T, E> {

    @Autowired(required=false)
    private RedisTemplate<String, Object> redisTemplate;

    private static final String FORMAT = "peanuts:%s:%s";

    @SuppressWarnings("unchecked")
    @Override
    public T getValue(E id) {
        return (T) redisTemplate.opsForValue().get(generateRedisKey(id));
    }

    @Override
    public T setValue(E id, T entity) {
        redisTemplate.opsForValue().set(generateRedisKey(id), entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getMultiValue(List<E> ids) {
        List<Object> resultList = redisTemplate.opsForValue()
                .multiGet(ids.stream().map(this::generateRedisKey).collect(Collectors.toList()));
        if (CommonUtils.isCollectionEmpty(resultList)) {
            return null;
        }
        return resultList.stream().map(obj -> (T) obj).collect(Collectors.toList());
    }

    @Override
    public Double increaseValue(E id, double delta) {
        return redisTemplate.opsForValue().increment(generateRedisKey(id), delta);
    }

    @Override
    public Long increaseValue(E id, long delta) {
        return redisTemplate.opsForValue().increment(generateRedisKey(id), delta);
    }

    @Override
    public void delete(E id) {
        redisTemplate.delete(generateRedisKey(id));
    }

    @Override
    public void expire(E id, long seconds) {
        redisTemplate.expire(generateRedisKey(id), seconds, TimeUnit.SECONDS);
    }

    protected abstract String entityName();

    private String generateRedisKey(E id) {
        return String.format(FORMAT, entityName(), id);
    }
}
