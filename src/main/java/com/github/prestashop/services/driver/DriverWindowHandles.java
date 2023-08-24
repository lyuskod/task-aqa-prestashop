package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IDriverWindowHandles;
import org.openqa.selenium.WebDriver;

public class DriverWindowHandles implements IDriverWindowHandles {
    private final WebDriver driver;

    public DriverWindowHandles(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void closeCurrentTab() {
        this.driver.close();
    }
}
