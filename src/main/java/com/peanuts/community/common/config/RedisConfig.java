package com.peanuts.community.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <pre>
 * Spring Configuration for Redis
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionInfo redisConnectionInfo;

    @Bean()
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = buildRedisStandaloneConfiguration();
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean()
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisFactory) {

        // RedisJsonSerializer
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // RedisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisFactory);
        redisTemplate.setEnableDefaultSerializer(false);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager cacheManager = RedisCacheManager.create(connectionFactory);
        return cacheManager;
    }

    private RedisStandaloneConfiguration buildRedisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisConnectionInfo.getHost());
        redisStandaloneConfiguration.setPort(redisConnectionInfo.getPort());
        redisStandaloneConfiguration.setDatabase(redisConnectionInfo.getDatabase());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisConnectionInfo.getPassword()));
        return redisStandaloneConfiguration;
    }
}
