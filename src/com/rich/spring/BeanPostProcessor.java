package com.rich.spring;

/**
 * @author: rich
 * @date: 2023/4/23 16:30
 * @description:
 */
public interface BeanPostProcessor {

    public Object postProcessBeforeInitialization(String beanName, Object bean);
    public Object postProcessAfterInitialization(String beanName, Object bean);
}
