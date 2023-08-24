package helpers;

import java.util.HashMap;

public class ModelHelper {

    private ModelHelper() {
    }

    public static HashMap<String, Object> getClassAttributesValues(Class clazz) {
        var classObj = clazz.getClass();
        var fields = classObj.getDeclaredFields();
        var storage = new HashMap<String, Object>();
        for (var field : fields) {
            try {
                storage.put(field.getName().toString(), field.get(classObj));
            } catch (IllegalArgumentException | IllegalAccessException ignored) {
            }
        }
        return storage;
    }
}
