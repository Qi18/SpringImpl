package com.rich.service;

import com.rich.spring.Autowired;
import com.rich.spring.Component;
import com.rich.spring.Scope;

/**
 * @author: rich
 * @date: 2023/4/20 20:10
 * @description:
 */
@Component("userService")
//@Scope("prototype")
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test(){
        System.out.println(orderService);
    }
}
