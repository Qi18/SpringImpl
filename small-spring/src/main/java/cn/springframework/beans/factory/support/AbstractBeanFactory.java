package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.BeanFactory;
import cn.springframework.beans.factory.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: rich
 * @date: 2023/4/23 19:50
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) return (T) bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
