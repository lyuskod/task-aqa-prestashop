package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IDriverSession;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.WebDriver;

public class DriverSession implements IDriverSession {
    private BaseLogger logger;
    private WebDriver driver;

    public DriverSession(WebDriver driver) {
        this.driver = driver;
        this.logger = BaseLogger.getLogger(DriverSession.class);
    }

    @Override
    public void end() {
        logger.info("[READY]: End driver session");
        this.driver.close();
        logger.info("[SUCCESS]: End driver session");
    }
}
