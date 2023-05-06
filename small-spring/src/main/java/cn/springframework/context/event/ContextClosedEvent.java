package cn.springframework.context.event;

/**
 * @author: rich
 * @date: 2023/5/6 11:37
 * @description:
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    //关闭动作
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
