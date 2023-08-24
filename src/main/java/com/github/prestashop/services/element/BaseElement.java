package com.github.prestashop.services.element;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.interfaces.element.IBaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement implements IBaseElement {
    private final By locator;

    private final String name;

    protected BaseDriver driver;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        this.driver = AutomationService.get().browser();
    }

    protected WebElement findElement() {
        return this.driver.getOriginalDriver().findElement(this.locator);
    }

    @Override
    public By getLocator() {
        return this.locator;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void click() {
        this.findElement().click();
    }

    @Override
    public boolean isDisplayed() {
        return this.findElement().isDisplayed();
    }
}
