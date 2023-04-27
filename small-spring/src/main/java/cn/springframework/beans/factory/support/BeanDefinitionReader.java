package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.core.io.Resource;
import cn.springframework.core.io.ResourceLoader;

/**
 * @author: rich
 * @date: 2023/4/26 12:49
 * @description:
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resource) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;
}
