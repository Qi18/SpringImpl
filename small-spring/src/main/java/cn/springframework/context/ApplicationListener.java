package cn.springframework.context;

import java.util.EventListener;

/**
 * @author: rich
 * @date: 2023/5/6 11:45
 * @description:
 */
public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
