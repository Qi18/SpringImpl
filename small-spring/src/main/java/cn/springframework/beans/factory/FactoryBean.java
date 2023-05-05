package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/5/5 10:51
 * @description:
 */
public interface FactoryBean <T>{

    T getObject() throws Exception;

    Class< ? > getObjectType();

    boolean isSingleton();
}
