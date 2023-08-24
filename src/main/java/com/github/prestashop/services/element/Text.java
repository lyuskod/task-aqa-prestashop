package com.github.prestashop.services.element;

import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;

public class Text extends BaseElement {

    private final BaseLogger logger = BaseLogger.getLogger(Text.class);

    public Text(By locator, String name) {
        super(locator, name);
    }

    public String getTextValue() {
        logger.info(String.format("[READY]: Get '%s' element's test value by '%s' locator", getName(), getLocator()));
        var text = findElement().getText();
        logger.info(String.format("[SUCCESS]: Get '%s' element's test value by '%s' locator. Text is: %s", getName(), getLocator(), text));
        return text;
    }
}
