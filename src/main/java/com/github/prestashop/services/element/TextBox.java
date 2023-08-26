package com.github.prestashop.services.element;

import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends BaseElement {
    private final BaseLogger logger = BaseLogger.getLogger(TextBox.class);

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void clearAndType(String content) {
        logger.info(String.format("[READY]: Clear and type into '%s' input with locator '%s' the following content: '%s'", getName(), getLocator(), content));
        var element = findElement();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(content);
        logger.info(String.format("[READY]: Clear and type into '%s' input with locator '%s'. Content sent: '%s'", getName(), getLocator(), content));
    }
}
