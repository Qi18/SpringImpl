package cn.springframework.context;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.Aware;

/**
 * @author: rich
 * @date: 2023/5/4 11:15
 * @description:
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
