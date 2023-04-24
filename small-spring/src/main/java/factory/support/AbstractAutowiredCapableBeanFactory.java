package factory.support;

import factory.config.BeanDefinition;

/**
 * @author: rich
 * @date: 2023/4/23 19:59
 * @description:
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            throw new Exception("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);//存入单例对象
        return bean;
    }
}
