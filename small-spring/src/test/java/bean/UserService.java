package bean;

import java.nio.file.attribute.UserPrincipal;

/**
 * @author: rich
 * @date: 2023/4/23 19:35
 * @description:
 */
public class UserService {

    private String name;

    public UserService() {

    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUser(){
        System.out.println("查询用户信息" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
