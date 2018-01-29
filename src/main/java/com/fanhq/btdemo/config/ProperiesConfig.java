package com.fanhq.btdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Hachel on 2018/1/29
 */
@ConfigurationProperties(
        prefix = "myProp"
)
public class ProperiesConfig {

    private String name;

    private String man;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
