package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/4/24 11:55
 * @description:
 */
public class BeansException extends Exception{
    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }
}
