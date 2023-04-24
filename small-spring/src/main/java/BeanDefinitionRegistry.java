/**
 * @author: rich
 * @date: 2023/4/23 20:03
 * @description:
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
