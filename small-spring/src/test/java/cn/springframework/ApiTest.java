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
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);


        userService01.queryUser();
    }




}
