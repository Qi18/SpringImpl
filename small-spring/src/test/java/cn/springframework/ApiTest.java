package cn.springframework;

import cn.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.springframework.bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.springframework.context.support.ClassPathXmlApplicationContext;
import cn.springframework.core.io.DefaultResourceLoader;
import cn.springframework.core.io.Resource;
import cn.springframework.event.CustomEvent;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: rich
 * @date: 2023/4/23 19:37
 * @description:
 */

public class ApiTest {


    @Test
    public void test() throws IOException, BeansException {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
    }




}
