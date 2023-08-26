package com.github.prestashop.transformations;

import com.github.prestashop.helpers.PageHelper;
import io.cucumber.java.ParameterType;

public class ParameterTypeTransformations {
    @ParameterType("opened|not opened|closed")
    public boolean isOpenedTransform(String value) {
        return value.equals("opened");
    }

    @ParameterType("Main|Art|Product Added|Accessories|Shopping Cart|Clothes|Personal Information|Addresses|Shipping Method|Payment|Order confirmed")
    public PageHelper.Pages pageNameTransform(String pageName) {
        return PageHelper.Pages.parse(pageName);
    }
}
