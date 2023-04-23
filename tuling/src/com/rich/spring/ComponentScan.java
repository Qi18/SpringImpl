package com.rich.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: rich
 * @date: 2023/4/20 20:07
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME) //生效时间
@Target(ElementType.TYPE) //写在类上
public @interface ComponentScan {
    String value() default "";
}
