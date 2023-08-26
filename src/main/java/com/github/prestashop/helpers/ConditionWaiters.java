package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionWaiters {
    private static final BaseLogger logger = BaseLogger.getLogger(ConditionWaiters.class);

    private ConditionWaiters() {
    }

    public static void waitUntilClickable(By locator, Duration timeout) {
        logger.info(String.format("[READY]: Wait until element clickable. Locator: '%s'. Timeout: '%s'", locator, timeout));
        new WebDriverWait(Automation.get().browser().getOriginalDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
        logger.info(String.format("[SUCCESS]: Wait until element clickable. Locator: '%s'. Timeout: '%s'", locator, timeout));
    }

    public static void waitUntilVisible(By locator, Duration timeout) {
        logger.info(String.format("[READY]: Wait until element visible. Locator: '%s'. Timeout: '%s'", locator, timeout));
        new WebDriverWait(Automation.get().browser().getOriginalDriver(), timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info(String.format("[SUCCESS]: Wait until element visible. Locator: '%s'. Timeout: '%s'", locator, timeout));
    }

    public static void waitUntilNotDisplayed(By locator, Duration timeout) {
        logger.info(String.format("[READY]: Wait until element visible. Locator: '%s'. Timeout: '%s'", locator, timeout));
        try {
            logger.warn(String.format("[WARN]: Attempt to wait until element visible. Locator: '%s'. Timeout: '%s'", locator, timeout));
            new WebDriverWait(Automation.get().browser().getOriginalDriver(), timeout)
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException ignored) {
            logger.warn(String.format("[WARN]: Timeout exception to wait until element visible is ignored. Locator: '%s'. Timeout: '%s'", locator, timeout));
        }
    }
}

