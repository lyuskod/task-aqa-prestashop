package com.github.prestashop.interfaces.driver;

import com.github.prestashop.services.driver.DriverTimeouts;
import com.github.prestashop.services.driver.DriverWindow;
import org.openqa.selenium.WebDriver;

public interface IBaseDriver {
    void go(String url);

    DriverWindow window();

    DriverTimeouts timeouts();

    WebDriver getOriginalDriver();
}
