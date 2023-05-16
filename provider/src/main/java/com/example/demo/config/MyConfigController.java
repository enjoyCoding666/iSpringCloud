package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class MyConfigController {

    @Autowired
    private MyConfig config;

    @RequestMapping("/provider/config/my")
    public String getConfig() {
        return config.getName();
    }

}

