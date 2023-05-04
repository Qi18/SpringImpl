package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

/**
 * @author: rich
 * @date: 2023/5/4 11:11
 * @description:
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
