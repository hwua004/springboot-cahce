package com.hwua.springboot.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericFastJsonRedisSerializer());
        return template;
    }

    @Bean
    @Primary
    public CacheManager cacheManager(RedisTemplate<Object, Object> myRedisTemplate){
        RedisCacheManager manager=new RedisCacheManager(myRedisTemplate);
        return manager;
    }
    @Bean
    public CacheManager concurrentMapCacheManager(){
        ConcurrentMapCacheManager mapCacheManager= new ConcurrentMapCacheManager();
        return mapCacheManager;
    }


}
