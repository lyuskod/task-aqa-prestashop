package com.github.prestashop.services.driver;

import org.openqa.selenium.WebDriver;

public class RemoteDriver extends BaseDriver{
    public RemoteDriver(WebDriver driver) {
        super(driver);
    }
}
