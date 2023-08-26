package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IDriverTimeouts;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

import java.time.Duration;

public class DriverTimeouts implements IDriverTimeouts {
    private BaseLogger logger;
    private final Timeouts timeouts;

    public enum PredefinedTimeouts {
        MIN_1(Duration.ofMinutes(1)),
        SEC_10(Duration.ofSeconds(10));

        private final Duration duration;

        PredefinedTimeouts(Duration duration) {
            this.duration = duration;
        }

        public Duration getDuration() {
            return this.duration;
        }
    }

    public DriverTimeouts(WebDriver driver) {
        this.timeouts = driver.manage().timeouts();
        this.logger = BaseLogger.getLogger(DriverTimeouts.class);
    }

    public void setDefaultTimeouts() {
        this.setImplicitTime(PredefinedTimeouts.SEC_10.getDuration());
        this.setPageLoadTime(PredefinedTimeouts.SEC_10.getDuration());
        this.setScriptTimeout(PredefinedTimeouts.SEC_10.getDuration());
    }

    @Override
    public void setImplicitTime(Duration duration) {
        logger.info(String.format("[READY]: Set driver implicit wait timeout to '%s'", duration));
        this.timeouts.implicitlyWait(duration);
        logger.info(String.format("[SUCCESS]: Set driver implicit wait timeout to '%s'", duration));
    }

    @Override
    public void setPageLoadTime(Duration duration) {
        logger.info(String.format("[READY]: Set driver page load wait timeout to '%s'", duration));
        this.timeouts.pageLoadTimeout(duration);
        logger.info(String.format("[SUCCESS]: Set driver page load wait timeout to '%s'", duration));
    }

    @Override
    public void setScriptTimeout(Duration duration) {
        logger.info(String.format("[READY]: Set driver script load wait timeout to '%s'", duration));
        this.timeouts.scriptTimeout(duration);
        logger.info(String.format("[SUCCESS]: Set driver script load wait timeout to '%s'", duration));
    }
}
