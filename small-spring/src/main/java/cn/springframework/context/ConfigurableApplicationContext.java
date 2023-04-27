package cn.springframework.context;

import cn.springframework.beans.BeansException;

/**
 * @author: rich
 * @date: 2023/4/27 16:18
 * @description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
