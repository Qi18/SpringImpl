package com.rich.service;

import com.rich.spring.BeanPostProcessor;
import com.rich.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: rich
 * @date: 2023/4/23 16:32
 * @description:
 */
@Component
public class RichBeanPostProcessor implements BeanPostProcessor {//参与构造Bean
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("初始化前");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("初始化后");
            Object proxyInstance = Proxy.newProxyInstance(RichBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面逻辑");
                    return method.invoke(bean, args);
                }//JDK自己的动态代理，代理的是UserInterface接口
            });
            return proxyInstance;
        }
        return bean;
    }

}
