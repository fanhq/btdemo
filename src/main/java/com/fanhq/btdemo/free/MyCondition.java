package com.fanhq.btdemo.free;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Hachel on 2018/1/31
 */
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取jvm参数
//        Environment env = conditionContext.getEnvironment();
//        String p1 = env.getProperty("p1", "0");
//        System.out.println(p1);
//        //获取注解值
//        Object objName = annotatedTypeMetadata.getAnnotationAttributes("org.springframework.stereotype.Component").get("value");
//        System.out.println(objName);
        return false;
    }
}
