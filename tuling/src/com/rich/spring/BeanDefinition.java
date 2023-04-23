package com.rich.spring;

/**
 * @author: rich
 * @date: 2023/4/21 11:30
 * @description:
 */
public class BeanDefinition {//Bean的定义

    private Class type;
    private String scope;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
