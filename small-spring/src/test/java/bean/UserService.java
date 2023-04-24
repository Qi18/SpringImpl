package bean;

import java.nio.file.attribute.UserPrincipal;

/**
 * @author: rich
 * @date: 2023/4/23 19:35
 * @description:
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUser(){
        System.out.println("查询用户信息");
    }
}
