package cn.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.PropertyValue;
import cn.springframework.beans.PropertyValues;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author: rich
 * @date: 2023/4/23 19:59
 * @description:
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            //依赖注入
            applyPropertyValue(beanName, bean, beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("Instantiation of bean failed");
        }
        addSingleton(beanName, bean);//存入单例对象
        return bean;
    }

    //bean实例化
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor constructor = null;
        Class< ? > beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {//只是数量对比，而实际Spring还要对比类型
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    //bean的属性注入
    protected void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("Error setting property values:" + beanName);
        }
    }


}
