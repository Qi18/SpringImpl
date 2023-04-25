package cn.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: rich
 * @date: 2023/4/25 16:53
 * @description:
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue value) {
        this.propertyValueList.add(value);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName))
                return pv;
        }
        return null;
    }
}

