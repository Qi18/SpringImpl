package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/4/28 10:22
 * @description:
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
