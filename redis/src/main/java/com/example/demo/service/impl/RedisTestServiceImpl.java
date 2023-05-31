package com.example.demo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RedisTestServiceImpl {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 缓存的前缀
     */
    private static final String PREFIX = "PREFIX_";


    public String getData(String id) {
        String key = PREFIX + id;
        String data = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(data)) {
            return data;
        }
        //实际中一般是从数据库中查询，有数据就插入缓存。
        String value = "test";
        //缓存5分钟
        redisTemplate.opsForValue().set(key, value, 5L, TimeUnit.MINUTES);
        return value;
    }


}
