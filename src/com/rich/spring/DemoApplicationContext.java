package com.rich.spring;

import com.rich.service.AppConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: rich
 * @date: 2023/4/20 20:05
 * @description:
 */
public class DemoApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    private ConcurrentHashMap<String, Object> singletonOjects = new ConcurrentHashMap<String, Object>(); //单例池
    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public DemoApplicationContext(Class appConfigClass) {
        this.configClass = appConfigClass;
        //扫描，得到beanDefinitionMap
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value(); //扫描路径 com.rich.service
            //需要扫描class文件
            path = path.replace(".","/");//相对路径
            ClassLoader classLoader = DemoApplicationContext.class.getClassLoader();//类加载器含有绝对路径
            URL resource = classLoader.getResource(path);//URL就是文件夹
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File f : files) {
                    //筛选class文件
                    String fileName = f.getAbsolutePath();
                    if (fileName.endsWith(".class")) {
                        //com\rich\service\UserService
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                        className = className.replace("\\",".");
                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            if (clazz.isAnnotationPresent(Component.class)) {

                                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                    BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                                    beanPostProcessorList.add(instance);
                                }

                                Component annotation = clazz.getAnnotation(Component.class);
                                String beanName = annotation.value();
                                if (beanName.endsWith("")) {//没有命名
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }
                                //是一个Bean
                                //BeanDefinition,便于getBean不用解析就获得相应对象
                                //单例，多例
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        //创建单例bean对象,实例化
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonOjects.put(beanName, bean);
            }

        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {//模拟bean的生命周期
        Class clazz = beanDefinition.getType();
        try {
            Object instance = clazz.getConstructor().newInstance(); //存在无参的构造方法
            //对bean的属性赋值，依赖注入
            for (Field f : clazz.getDeclaredFields()) {
              if (f.isAnnotationPresent(Autowired.class)) {
                  f.setAccessible(true);
                  f.set(instance, getBean(f.getName()));//先type后name
              }
            }
            //Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }//Spring会告诉某个东西给bean
            //初始化前
            for (BeanPostProcessor beanPostProcessor: beanPostProcessorList) {
                beanPostProcessor.postProcessBeforeInitialization(beanName, instance);
            }
            //初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }//Spring会调用这个方法
            //初始化后
            for (BeanPostProcessor beanPostProcessor: beanPostProcessorList) {
                beanPostProcessor.postProcessAfterInitialization(beanName, instance);
            }
            //初始化后 AOP
            //BeanPostProcessor Bean的后置处理器


            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException();
        } else {
            String scope = beanDefinition.getScope();
            if (scope.equals("singleton")) {
                Object bean = singletonOjects.get(beanName);
                if (bean == null) {
                    bean = createBean(beanName, beanDefinition);
                    singletonOjects.put(beanName, bean);
                }
                return bean;
            } else {
                //多例
                return createBean(beanName, beanDefinition);
            }
        }
    }
}
