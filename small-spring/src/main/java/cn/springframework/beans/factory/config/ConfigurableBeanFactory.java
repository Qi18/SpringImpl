package cn.springframework.beans.factory.config;

import cn.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author: rich
 * @date: 2023/4/26 20:08
 * @description:
 */

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.springframework.beans.factory.BeanFactory}
 * interface.
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

//    /**
//     * 销毁单例对象
//     */
//    void destroySingletons();
}
