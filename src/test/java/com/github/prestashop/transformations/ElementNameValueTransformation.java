package com.github.prestashop.transformations;

import com.github.prestashop.cucumber.dto.ElementDto;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Map;

public class ElementNameValueTransformation implements TypeRegistryConfigurer {
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(ElementDto.class, (Map<String, String> row) -> {
            String name = row.get("Element Name").trim();
            String value = row.get("Element Value").trim();
            return new ElementDto(name, value);
        }));
    }
}
