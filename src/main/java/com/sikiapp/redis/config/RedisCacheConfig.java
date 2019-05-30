/**
 * projectName: spring-boot-in-action
 * fileName: RedisCacheConfig.java
 * packageName: com.sikiapp.redis.redis
 * date: 2019-05-28 上午11:01
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RedisCacheConfig
 * @packageName: com.sikiapp.redis.redis
 * @description: Redis 缓存配置
 * @author: Robert
 * @data: 2019-05-28 上午11:01
 * @version: V1.0
 **/
//@Configuration
//@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }



}