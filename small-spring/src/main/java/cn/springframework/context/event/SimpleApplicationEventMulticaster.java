package cn.springframework.context.event;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.BeanFactory;
import cn.springframework.context.ApplicationEvent;
import cn.springframework.context.ApplicationListener;

/**
 * @author: rich
 * @date: 2023/5/6 12:09
 * @description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) throws BeansException {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) throws BeansException {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
