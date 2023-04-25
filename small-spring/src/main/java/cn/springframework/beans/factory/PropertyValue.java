package cn.springframework.beans.factory;

/**
 * @author: rich
 * @date: 2023/4/25 16:53
 * @description:
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
