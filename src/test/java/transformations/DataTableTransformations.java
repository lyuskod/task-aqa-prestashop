package transformations;

import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.qameta.allure.internal.shadowed.jackson.databind.JavaType;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.Map;

public class DataTableTransformations {
    private final ObjectMapper mapper = new ObjectMapper();

    @DefaultDataTableEntryTransformer
    public Object transformDataTable(Map<String, String> entry, Type toValueType) {
        JavaType constructedType = mapper.constructType(toValueType);
        return mapper.convertValue(entry, constructedType);
    }
}
