package com.fanhq.btdemo.free;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/29
 */
@Component
@ConfigurationProperties(
        prefix = "myProp"
)
@Conditional({MyCondition.class})
public class ProperiesConfig {

    private String name;

    private String addrMy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddrMy() {
        return addrMy;
    }

    public void setAddrMy(String addrMy) {
        this.addrMy = addrMy;
    }
}
