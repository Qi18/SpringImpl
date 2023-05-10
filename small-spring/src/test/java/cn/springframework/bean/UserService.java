package cn.springframework.bean;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.*;
import cn.springframework.context.ApplicationContext;
import cn.springframework.context.ApplicationContextAware;

import java.util.Random;

/**
 * @author: rich
 * @date: 2023/4/23 19:35
 * @description:
 */
public class UserService implements IUserService{

    private String uId;

//    private UserDao userDao;


    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

}
