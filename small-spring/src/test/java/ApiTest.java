import bean.UserDao;
import bean.UserService;
import cn.springframework.beans.factory.PropertyValue;
import cn.springframework.beans.factory.PropertyValues;
import cn.springframework.beans.factory.config.BeanDefinition;
import cn.springframework.beans.factory.config.BeanReference;
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
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        //对每个bean都有一个beanDefinition
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        //初始化bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();
    }

}
