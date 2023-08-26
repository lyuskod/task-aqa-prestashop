package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IBaseDriver;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.WebDriver;

public abstract class BaseDriver implements IBaseDriver {
    private BaseLogger logger;

    private final WebDriver driver;

    private final DriverWindow window;

    private final DriverTimeouts timeouts;

    private final DriverSession session;

    public BaseDriver(WebDriver driver) {
        this.driver = driver;
        this.window = new DriverWindow(this.driver);
        this.timeouts = new DriverTimeouts(this.driver);
        this.session = new DriverSession(this.driver);
        this.logger = BaseLogger.getLogger(BaseDriver.class);
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
    public DriverSession session() {
        return this.session;
    }

    @Override
    public void go(String url) {
        logger.info(String.format("[READY]: Navigate to url '%s'", url));
        this.driver.get(url);
        logger.info(String.format("[SUCCESS]: Navigate to url '%s'", url));
    }

    @Override
    public WebDriver getOriginalDriver() {
        return this.driver;
    }
}
