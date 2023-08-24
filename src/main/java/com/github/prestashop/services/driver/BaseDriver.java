package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IBaseDriver;
import org.openqa.selenium.WebDriver;

public abstract class BaseDriver implements IBaseDriver {
    private final WebDriver driver;

    private final DriverWindow window;

    private final DriverTimeouts timeouts;

    private final DriverWindowHandles windowHandles;

    private final DriverSession session;

    public BaseDriver(WebDriver driver) {
        this.driver = driver;
        this.window = new DriverWindow(this.driver);
        this.timeouts = new DriverTimeouts(this.driver);
        this.windowHandles = new DriverWindowHandles(this.driver);
        this.session = new DriverSession(this.driver);
    }

    @Override
    public DriverWindow window() {
        return this.window;
    }

    @Override
    public DriverTimeouts timeouts() {
        return this.timeouts;
    }

    @Override
    public DriverWindowHandles windowHandles() {
        return this.windowHandles;
    }

    @Override
    public DriverSession session() {
        return this.session;
    }

    @Override
    public void go(String url) {
        this.driver.get(url);
    }

    @Override
    public WebDriver getOriginalDriver() {
        return this.driver;
    }
}
