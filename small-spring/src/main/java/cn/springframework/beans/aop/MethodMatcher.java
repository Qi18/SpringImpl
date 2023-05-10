package cn.springframework.beans.aop;

import java.lang.reflect.Method;

/**
 * @author: rich
 * @date: 2023/5/8 15:53
 * @description:
 */
//方法匹配，找到表达式范围内匹配下的目标类和方法
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
