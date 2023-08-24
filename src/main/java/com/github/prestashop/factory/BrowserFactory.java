package com.github.prestashop.factory;

import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.services.driver.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
    public enum BrowserTypes {
        FIREFOX
    }

    private BrowserFactory() {
    }

    public static BaseDriver getDriver(BrowserTypes type) {
        WebDriverManager.firefoxdriver().setup();
        BaseDriver driver = new FirefoxDriver(new org.openqa.selenium.firefox.FirefoxDriver());
        return driver;
    }
}
