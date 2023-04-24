package cn.springframework.beans.factory.config;

/**
 * @author: rich
 * @date: 2023/4/23 19:47
 * @description:
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
