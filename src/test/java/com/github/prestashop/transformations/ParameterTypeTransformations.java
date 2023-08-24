package com.github.prestashop.transformations;

import io.cucumber.java.ParameterType;

public class ParameterTypeTransformations {
    @ParameterType("opened|not opened")
    public boolean isOpenedTransform(String value)
    {
        return !value.contains("not");
    }
}
