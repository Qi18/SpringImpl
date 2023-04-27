package cn.springframework.common;

import cn.springframework.bean.UserService;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: rich
 * @date: 2023/4/27 19:05
 * @description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setuId("10002");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
