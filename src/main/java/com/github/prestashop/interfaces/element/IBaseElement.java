package com.github.prestashop.interfaces.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface IBaseElement {
    By getLocator();

    String getName();

    void click();

    boolean isDisplayed();
}
