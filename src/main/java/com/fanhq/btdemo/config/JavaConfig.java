package com.fanhq.btdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hachel on 2018/1/29
 *
 *
 * @Bean 1.可以通过参数传递依赖bean  2、可以通过方法获取依赖bean
 *
 *
 */

@Configuration
public class JavaConfig {

    //1.可以通过参数传递依赖bean
//    @Bean
//    public MyConfig getMyConfig(ProperiesConfig properiesConfig){
//        return new MyConfig();
//    }


    //2、可以通过方法获取依赖bean
    @Bean
    public MyConfig getMyConfig(){
        ProperiesConfig properiesConfig = getProperiesConfig();
        return new MyConfig(properiesConfig);
    }

    @Bean
    public ProperiesConfig getProperiesConfig(){
        return new ProperiesConfig();
    }
}
