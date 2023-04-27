package cn.springframework.beans.factory.config;

import cn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author: rich
 * @date: 2023/4/26 20:08
 * @description:
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
