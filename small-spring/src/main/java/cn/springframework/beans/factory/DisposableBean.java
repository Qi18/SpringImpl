package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/4/28 10:23
 * @description:
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
