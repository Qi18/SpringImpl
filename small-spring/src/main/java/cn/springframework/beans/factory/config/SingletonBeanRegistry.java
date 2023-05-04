package cn.springframework.beans.factory.config;

import cn.springframework.beans.BeansException;

/**
 * @author: rich
 * @date: 2023/4/23 19:47
 * @description:
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void destroySingletons() throws BeansException;
}
