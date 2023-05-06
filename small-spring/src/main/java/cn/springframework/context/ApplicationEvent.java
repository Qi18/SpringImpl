package cn.springframework.context;

import java.util.EventObject;

/**
 * @author: rich
 * @date: 2023/5/6 11:33
 * @description:
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
