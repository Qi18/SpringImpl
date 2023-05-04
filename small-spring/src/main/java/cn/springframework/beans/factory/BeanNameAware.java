package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/5/4 11:14
 * @description:
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
