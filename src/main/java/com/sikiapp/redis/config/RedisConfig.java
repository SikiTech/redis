/**
 * projectName: redis
 * fileName: RedisConfig.java
 * packageName: com.sikiapp.redis.config
 * date: 2019-05-28 下午3:24
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @className: RedisConfig
 * @packageName: com.sikiapp.redis.config
 * @description: 创建RedisConnectionFactory 对象
 * @author: Robert
 * @data: 2019-05-28 下午3:24
 * @version: V1.0
 **/
@Configuration
public class RedisConfig {

    @Bean
    @ConditionalOnMissingBean
    public RedisConnectionFactory initRedisConnectionFactory() {
        // 连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(50);
        poolConfig.setMaxIdle(30);
        poolConfig.setMaxWaitMillis(2000);

        // 创建Jedis连接工厂
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
        RedisStandaloneConfiguration rsCfg = connectionFactory.getStandaloneConfiguration();
        rsCfg.setHostName("localhost");
        rsCfg.setPort(6379);
        return connectionFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public RedisTemplate<Object, Object> initRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        // 设置序列化器
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

//    @Bean
//    @ConditionalOnMissingBean
    public RedisCacheManager initRedisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()))
                .disableKeyPrefix()
                .entryTtl(Duration.ofMinutes(10));
        return new RedisCacheManager(writer, config);

    }
}