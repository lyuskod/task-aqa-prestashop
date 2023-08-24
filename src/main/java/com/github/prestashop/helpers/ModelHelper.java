package com.github.prestashop.helpers;

import java.util.HashMap;

public class ModelHelper {

    private ModelHelper() {
    }

    public static HashMap<String, Object> getClassAttributesValues(Class clazz) {
        var fields = clazz.getDeclaredFields();
        var storage = new HashMap<String, Object>();
        for (var field : fields) {
            try {
                storage.put(field.getName(), field.get(clazz));
            } catch (IllegalArgumentException | IllegalAccessException ignored) {
            }
        }
        return storage;
    }
}
