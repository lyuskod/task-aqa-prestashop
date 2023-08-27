package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.Automation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JSHelper {

    private JSHelper() {
    }

    public static void highlightElement(By locator) {
        var driver = Automation.get().browser().getOriginalDriver();
        var element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
