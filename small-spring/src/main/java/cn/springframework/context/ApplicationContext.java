package cn.springframework.context;

import cn.springframework.beans.factory.HierarchicalBeanFactory;
import cn.springframework.beans.factory.ListableBeanFactory;
import cn.springframework.core.io.ResourceLoader;

/**
 * @author: rich
 * @date: 2023/4/27 16:17
 * @description:
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
