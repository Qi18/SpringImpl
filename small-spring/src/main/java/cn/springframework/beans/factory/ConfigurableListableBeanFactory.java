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


/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 */

public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory,ListableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
