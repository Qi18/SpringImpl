package cn.springframework.bean;

/**
 * @author: rich
 * @date: 2023/5/10 12:45
 * @description:
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);
}
