package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.BaseDriver;

import java.time.Duration;

public class BrowserHelper {
    private BrowserHelper() {
    }

    public static void configureBrowser(BaseDriver driver) {
        configureTimeouts(driver);
        configureScreenMode(driver);
    }

    public static void configureTimeouts(BaseDriver driver) {
        var pageLoadTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutPageLoadSec());
        var scriptTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutScriptSec());
        var implicitWaitTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutImplicitSec());
        driver.timeouts().setPageLoadTime(pageLoadTimeout);
        driver.timeouts().setScriptTimeout(scriptTimeout);
        driver.timeouts().setImplicitTime(implicitWaitTimeout);
    }

    public static void configureScreenMode(BaseDriver driver) {
        var screenResolution = ConfigHelper.get().getScreenResolution();
        driver.window().setSize(screenResolution.getWidth(), screenResolution.getHeight());
    }

    public static void delay() {
        var delay = ConfigHelper.get().getExecutionSpeedDelaySec();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
