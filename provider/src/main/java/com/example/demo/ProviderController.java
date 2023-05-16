package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProviderController {

    /**
     *  后面的 :abc 表示默认值为 abc。
     */
    @Value("${my.name:abc}")
    private String configName;

    @GetMapping(value = "/provider/test")
    public String test() {
        return "Hello World~";
    }

    @GetMapping(value = "/provider/config")
    public String getConfig() {
        return configName;
    }
}
