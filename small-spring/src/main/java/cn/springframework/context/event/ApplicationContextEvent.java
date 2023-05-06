package cn.springframework.context.event;

import cn.springframework.context.ApplicationContext;
import cn.springframework.context.ApplicationEvent;

/**
 * @author: rich
 * @date: 2023/5/6 11:35
 * @description:
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
