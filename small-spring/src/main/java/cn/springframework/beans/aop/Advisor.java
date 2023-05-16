package cn.springframework.beans.aop;

import org.aopalliance.aop.Advice;

/**
 * @author: rich
 * @date: 2023/5/10 13:52
 * @description:
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
