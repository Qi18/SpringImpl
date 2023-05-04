package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/5/4 11:12
 * @description:
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
