package cn.springframework.core.io;

/**
 * @author: rich
 * @date: 2023/4/26 12:42
 * @description:
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PRE = "classpath:";

    Resource getResource(String location);
}
