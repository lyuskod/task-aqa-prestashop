package com.github.prestashop.transformations;

import com.github.prestashop.helpers.PageHelper;
import io.cucumber.java.ParameterType;

public class ParameterTypeTransformations {
    @ParameterType("opened|not opened")
    public boolean isOpenedTransform(String value) {
        return !value.contains("not");
    }

    @ParameterType("Main|Art|Product Added")
    public PageHelper.Pages pageNameTransform(String pageName) {
        return PageHelper.Pages.parse(pageName);
    }
}
