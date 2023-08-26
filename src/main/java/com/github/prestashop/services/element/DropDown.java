package com.github.prestashop.services.element;

import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {

    private final BaseLogger logger = BaseLogger.getLogger(DropDown.class);

    public DropDown(By locator, String name) {
        super(locator, name);
    }

    public void selectByVisibleText(String text) {
        logger.info(String.format("[READY]: Select '%s' value in '%s' checkbox with locator: '%s'", getName(), text, getLocator()));
        new Select(findElement()).selectByVisibleText(text);
        logger.info(String.format("[SUCCESS]: Select '%s' value in '%s' checkbox with locator: '%s'", getName(), text, getLocator()));
    }
}
