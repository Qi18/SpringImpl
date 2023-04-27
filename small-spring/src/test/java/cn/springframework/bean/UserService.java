package cn.springframework.bean;

/**
 * @author: rich
 * @date: 2023/4/23 19:35
 * @description:
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void queryUser(){
        System.out.println("查询用户信息" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
