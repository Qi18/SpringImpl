package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: rich
 * @date: 2023/4/23 19:59
 * @description:
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("Instantiation of bean failed");
        }
        addSingleton(beanName, bean);//存入单例对象
        return bean;
    }
}
