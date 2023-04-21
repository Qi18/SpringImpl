package com.rich.service;

import com.rich.spring.DemoApplicationContext;

public class Main {

    public static void main(String[] args) {

        DemoApplicationContext context = new DemoApplicationContext(AppConfig.class);//启动Spring容器

        UserService userService = (UserService)context.getBean("userService");

        userService.test();
    }
}
