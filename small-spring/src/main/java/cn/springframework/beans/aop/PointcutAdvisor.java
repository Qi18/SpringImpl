package cn.springframework.beans.aop;

/**
 * @author: rich
 * @date: 2023/5/10 13:53
 * @description:
 */
public interface PointcutAdvisor extends Advisor{
    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
