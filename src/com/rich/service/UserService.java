package com.rich.service;

import com.rich.spring.*;

/**
 * @author: rich
 * @date: 2023/4/20 20:10
 * @description:
 */
@Component
public class UserService implements BeanNameAware, InitializingBean, UserInterface {

    @Autowired
    private OrderService orderService;

    private String beanName;

    private String xxx;

    public void test(){
        System.out.println(orderService);
    }


    @Override
    public void setBeanName(String beanName) {
        //Spring调用
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        //执行很多东西
        System.out.println("初始化方法");
    }
}
