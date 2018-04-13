package com.fanhq.btdemo.free;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hachel on 2018/1/29
 *
 * @Bean 1.可以通过参数传递依赖bean  2、可以通过方法获取依赖bean
 */

@Configuration
@Conditional({MyCondition.class})
public class JavaConfig {

//    //1.可以通过参数传递依赖bean
//    @Bean
//    @Qualifier(value = "MyConfig1")
//    public MyConfig getMyConfig(@Qualifier(value = "properiesConfig") ProperiesConfig properiesConfig){
//        return new MyConfig(properiesConfig);
//    }
//
//    //2、可以通过方法获取依赖bean
//    @Bean
//    @Qualifier(value = "MyConfig2")
//    public MyConfig getMyConfig() {
//        ProperiesConfig properiesConfig = getProperiesConfig();
//        return new MyConfig(properiesConfig);
//    }
//
//    @Bean
//    public ProperiesConfig getProperiesConfig() {
//        return new ProperiesConfig();
//    }
//
//    @Bean
//    public Serializable createSerializable() {
//        System.out.println("======inti======");
//        return StringUtils.EMPTY;
//    }
}
