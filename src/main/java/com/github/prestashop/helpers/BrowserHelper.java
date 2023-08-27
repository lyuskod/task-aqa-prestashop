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

    public static void resetImplicitTimeout(BaseDriver driver) {
        driver.timeouts().setImplicitTime(Duration.ofSeconds(0));
    }

    public static void setImplicitTimeout(BaseDriver driver) {
        var implicitWaitTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutImplicitSec());
        driver.timeouts().setImplicitTime(implicitWaitTimeout);
    }

    public static void setPageLoadTimeout(BaseDriver driver) {
        var pageLoadTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutPageLoadSec());
        driver.timeouts().setPageLoadTime(pageLoadTimeout);
    }

    public static void setScriptTimeOut(BaseDriver driver) {
        var scriptTimeout = Duration.ofSeconds(ConfigHelper.get().getTimeouts().getTimeoutScriptSec());
        driver.timeouts().setScriptTimeout(scriptTimeout);
    }

    public static void configureTimeouts(BaseDriver driver) {
        setImplicitTimeout(driver);
        setPageLoadTimeout(driver);
        setScriptTimeOut(driver);
    }

    public static void configureScreenMode(BaseDriver driver) {
        var screenResolution = ConfigHelper.get().getScreenResolution();
        driver.window().setSize(screenResolution.getWidth(), screenResolution.getHeight());
    }

    public static void delay() {
        var delay = ConfigHelper.get().getExecutionSpeedDelayMs();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
