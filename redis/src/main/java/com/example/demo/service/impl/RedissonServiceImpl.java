package com.example.demo.service.impl;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 参考资料： https://blog.csdn.net/weixin_53922163/article/details/127482085
 *
 */
@Service
public class RedissonServiceImpl {

    @Autowired
    private RedissonClient redissonClient;

    public void getRedissonLock() {
        RLock lock = redissonClient.getLock("myLock");
        lock.lock();
        System.out.println("已加锁，在此处执行逻辑.");
        lock.unlock();
    }

}
