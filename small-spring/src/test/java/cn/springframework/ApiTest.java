package cn.springframework;

import cn.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.springframework.bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
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

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");
        BeanDefinitionRegistry registry = reader.getRegistry();
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUser();
    }



}
