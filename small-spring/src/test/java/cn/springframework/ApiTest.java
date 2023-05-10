package cn.springframework;

import cn.springframework.bean.IUserService;
import cn.springframework.bean.UserServiceInterceptor;
import cn.springframework.beans.aop.AdvisedSupport;
import cn.springframework.beans.aop.TargetSource;
import cn.springframework.beans.aop.aspectj.AspectJExpressionPointcut;
import cn.springframework.beans.aop.framework.Cglib2AopProxy;
import cn.springframework.beans.aop.framework.JdkDynamicAopProxy;
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
import java.lang.reflect.Method;

/**
 * @author: rich
 * @date: 2023/4/23 19:37
 * @description:
 */

public class ApiTest {


    @Test
    public void test() throws IOException, BeansException, NoSuchMethodException {
        IUserService userService = new UserService();

        AdvisedSupport advised = new AdvisedSupport();
        advised.setMethodInterceptor(new UserServiceInterceptor());
        advised.setTargetSource(new TargetSource(userService));
        advised.setMethodMatcher(new AspectJExpressionPointcut(("execution(* cn.springframework.bean.UserService.*(..))")));


        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advised).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advised).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }




}
