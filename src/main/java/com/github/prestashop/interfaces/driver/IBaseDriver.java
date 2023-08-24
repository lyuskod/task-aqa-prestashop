package com.github.prestashop.interfaces.driver;

import org.openqa.selenium.WebDriver;
import com.github.prestashop.services.driver.DriverSession;
import com.github.prestashop.services.driver.DriverTimeouts;
import com.github.prestashop.services.driver.DriverWindow;
import com.github.prestashop.services.driver.DriverWindowHandles;

public interface IBaseDriver {
    void go(String url);

    DriverWindow window();

    DriverTimeouts timeouts();

    DriverWindowHandles windowHandles();

    DriverSession session();

    WebDriver getOriginalDriver();
}
