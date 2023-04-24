package factory.support;

import factory.BeanFactory;
import factory.config.BeanDefinition;

/**
 * @author: rich
 * @date: 2023/4/23 19:50
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws Exception {
        Object bean = getSingleton(beanName);
        if (bean != null) return bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;
}
