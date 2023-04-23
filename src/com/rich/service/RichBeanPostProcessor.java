package com.rich.service;

import com.rich.spring.BeanPostProcessor;
import com.rich.spring.Component;

/**
 * @author: rich
 * @date: 2023/4/23 16:32
 * @description:
 */
@Component
public class RichBeanPostProcessor implements BeanPostProcessor {//参与构造Bean
    @Override
    public void postProcessBeforeInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("初始化前");
        }
    }

    @Override
    public void postProcessAfterInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("初始化后");
        }
    }

}
