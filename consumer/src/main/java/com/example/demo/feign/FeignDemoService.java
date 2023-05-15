package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "provider")
public interface FeignDemoService {

    @GetMapping("/provider/test")
    String test();

}
