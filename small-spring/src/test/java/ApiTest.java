import bean.UserService;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author: rich
 * @date: 2023/4/23 19:37
 * @description:
 */

public class ApiTest {

    @Test
    public void test_BeanFactory() throws Exception {
        //初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //对每个bean都有一个beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //初始化bean
        UserService userService = (UserService) beanFactory.getBean("userService", "薛之谦");
        userService.queryUser();
    }

}
