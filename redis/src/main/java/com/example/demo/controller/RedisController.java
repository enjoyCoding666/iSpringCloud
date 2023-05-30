package com.example.demo.controller;

import com.example.demo.config.RedisUtils;
import com.example.demo.domain.TtRecordEntity;
import com.example.demo.service.TtRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class RedisController {



    @Autowired
    TtRecordService recordService;

    @Autowired
    private RedisUtils redisUtils;


    @RequestMapping(value = "/record/{id}")
    public String hello(@PathVariable(value = "id") String id){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            log.info("从缓存获取的数据"+ object);
            str = object.toString();
        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            TtRecordEntity entity = recordService.getById(id);
            if (entity == null) {
                return "empty";
            }
            str = entity.getHandleUserName();
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,str,10L,TimeUnit.MINUTES);
            log.info("数据插入缓存" + str);
        }
        return str;
    }
}
