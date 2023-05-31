package com.example.demo.controller;

import com.example.demo.service.TtRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class RecordController {

    @Resource
    private TtRecordService recordService;

    @RequestMapping(value = "/record/{id}")
    public String getUserName(@PathVariable(value = "id") String id){
        return recordService.getRecord(id);
    }


}
