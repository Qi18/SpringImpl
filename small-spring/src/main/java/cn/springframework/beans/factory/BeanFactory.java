package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

/**
 * @author: rich
 * @date: 2023/4/23 19:33
 * @description:
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    /**
     *  重载多参数的getBean方法  这样可以方便的传递入参给构造函数
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
