package com.example.demo.service.impl;

import com.example.demo.domain.TtRecordEntity;
import com.example.demo.dao.TtRecordMapper;
import com.example.demo.service.TtRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 操作轨迹表 服务实现类
 * </p>
 *
 * @author xx
 * @since 2023-05-31
 */
@Service
@Slf4j
public class TtRecordServiceImpl extends ServiceImpl<TtRecordMapper, TtRecordEntity> implements TtRecordService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String PREFIX = "RECORD_";


    @Override
    public String getRecord(String id) {
        String key = PREFIX + id;
        String record = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(record)) {
            return record;
        }
        //从数据库中获取信息
        TtRecordEntity entity = getById(id);
        if (entity == null) {
            return null;
        }
        String userName = entity.getHandleUserName();
        //数据插入缓存
        redisTemplate.opsForValue().set(key, userName, 5L, TimeUnit.MINUTES);
        return userName;
    }


}
