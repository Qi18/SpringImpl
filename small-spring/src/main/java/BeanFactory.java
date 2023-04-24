import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: rich
 * @date: 2023/4/23 19:33
 * @description:
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
