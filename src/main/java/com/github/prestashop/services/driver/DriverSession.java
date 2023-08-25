package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IDriverSession;
import org.openqa.selenium.WebDriver;

public class DriverSession implements IDriverSession {
    private WebDriver driver;

    public DriverSession(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void end() {
        this.driver.close();
    }
}
