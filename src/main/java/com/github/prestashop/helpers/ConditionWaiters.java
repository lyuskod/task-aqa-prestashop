package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionWaiters {

    private ConditionWaiters() {
    }

    public static void waitUntilClickable(By locator, Duration timeout) {
        new WebDriverWait(AutomationService.get().browser().getOriginalDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilVisible(By locator, Duration timeout)
    {
        new WebDriverWait(AutomationService.get().browser().getOriginalDriver(), timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
