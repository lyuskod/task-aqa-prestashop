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
        var screenMode = ConfigHelper.get().getScreenMode();
        switch (ConfigHelper.get().getScreenMode()) {
            case "fullscreen":
                driver.window().setFullScreen();
                break;
            case "maximize":
                driver.window().setMaximize();
                break;
            default:
                throw new IllegalArgumentException(String.format("Screen mode '%s' is not allowed", screenMode));
        }
    }
}
