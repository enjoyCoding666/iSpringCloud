package com.example.demo;


import com.example.demo.feign.FeignDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private FeignDemoService feignDemoService;


    @GetMapping("/test")
    public String customer() {
        return feignDemoService.test();
    }

}