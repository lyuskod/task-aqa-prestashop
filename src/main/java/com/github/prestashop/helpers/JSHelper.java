package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.Automation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSHelper {

    private JSHelper() {
    }

    public static void removeHighlightFromElement(WebElement element) {
        var driver = Automation.get().browser().getOriginalDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='none'", element);
    }

    public static void highlightElement(WebElement element) {
        var driver = Automation.get().browser().getOriginalDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
