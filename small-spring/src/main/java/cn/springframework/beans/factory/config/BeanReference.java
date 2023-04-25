package cn.springframework.beans.factory.config;

/**
 * @author: rich
 * @date: 2023/4/25 16:53
 * @description:
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
