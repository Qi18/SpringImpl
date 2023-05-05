package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: rich
 * @date: 2023/5/5 11:02
 * @description:
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object oj = this.factoryBeanObjectCache.get(beanName);
        return oj == NULL_OBJECT ? null : (oj);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) throws BeansException {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        }else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) throws BeansException {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("factoryBean threw exception on object[" + beanName + "] creation");
        }
    }
}
