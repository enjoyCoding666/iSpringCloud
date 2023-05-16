package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * ConfigurationProperties做热更新。prefix 表示前缀，比如my.name，还有my.age，前缀就是 my
 */
@Component
@Data
@ConfigurationProperties(prefix = "my")
public class MyConfig {
    /**
     * my.name配置，对应前缀my,属性 name
     */
    private String name;

    private Integer age;
}

