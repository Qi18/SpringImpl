package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: rich
 * @date: 2023/4/25 16:54
 * @description:
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "薛之谦");
        hashMap.put("10002", "周杰伦");
        hashMap.put("10003", "林俊杰");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
