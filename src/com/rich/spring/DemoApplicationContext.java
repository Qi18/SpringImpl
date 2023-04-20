package com.rich.spring;

import com.rich.service.AppConfig;

import java.io.File;
import java.net.URL;

/**
 * @author: rich
 * @date: 2023/4/20 20:05
 * @description:
 */
public class DemoApplicationContext {

    private Class configClass;

    public DemoApplicationContext(Class appConfigClass) {
        this.configClass = appConfigClass;
        //扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value(); //扫描路径 com.rich.service
            //需要扫描class文件
            path = path.replace(".","/");//相对路径
            ClassLoader classLoader = DemoApplicationContext.class.getClassLoader();//类加载器含有绝对路径
            URL resource = classLoader.getResource(path);//URL就是文件夹

            File file = new File(resource.getFile());
            System.out.println(file);
            if (file.isDirectory()) {

            }
        }
    }

    public Object getBean(String beanName){
        return null;
    }
}
