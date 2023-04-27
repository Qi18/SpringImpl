package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author: rich
 * @date: 2023/4/26 20:09
 * @description:
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory,ListableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
