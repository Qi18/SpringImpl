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
import com.itextpdf.kernel.pdf.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;

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

    @Test
    public void get() throws IOException {

        String sourceFile = "C:\\Users\\rich\\Desktop\\pdf_lrq\\国家电网办〔2022〕619号.pdf";
        String destinationPath = "C:\\Users\\rich\\Desktop\\1.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(sourceFile), new PdfWriter(destinationPath));
        int numberOfPages = pdfDoc.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            PdfDictionary pageDict = pdfDoc.getPage(i).getPdfObject();

            PdfArray contents = pageDict.getAsArray(PdfName.Contents);
            PdfStream psw = contents.getAsStream(2);

            psw.setData("".getBytes());
            psw.clear();

            PdfDictionary resources = pageDict.getAsDictionary(PdfName.Resources);
            PdfDictionary fonts = resources.getAsDictionary(PdfName.Font);

            fonts.entrySet().forEach(x -> {
                if (x.getKey().toString().startsWith("/Xi")) {
                    PdfDictionary p = (PdfDictionary) x.getValue();
                    p.clear();
                }
            });
        }
        pdfDoc.close();
//        Files.delete(new File(sourceFile).toPath());
//        Files.move(new File(destinationPath).toPath(), new File(sourceFile).toPath());
    }





}
