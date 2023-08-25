package com.github.prestashop.interfaces.element;

import org.openqa.selenium.By;

public interface IBaseElement {
    By getLocator();

    String getName();

    void click();

    boolean isDisplayed();

    String getCssValue(String propertyName);
}
