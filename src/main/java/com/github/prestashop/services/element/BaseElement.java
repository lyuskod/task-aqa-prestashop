package com.github.prestashop.services.element;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElement implements IBaseElement {
    private final By locator;

    private final String name;

    protected BaseDriver driver;

    private final BaseLogger logger = BaseLogger.getLogger(BaseElement.class);

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        this.driver = AutomationService.get().browser();
    }

    protected WebElement findElement() {
        logger.debug(String.format("[READY]: Find '%s' element by locator: %s", this.name, this.locator));
        var element = this.driver.getOriginalDriver().findElement(this.locator);
        logger.debug(String.format("[SUCCESS]: Find '%s' element by locator: %s. Element is found", this.name, this.locator));
        return element;
    }

    protected List<WebElement> findElements() {
        logger.debug(String.format("[READY]: Find '%s' multiple elements by locator: %s", this.name, this.locator));
        var elements = this.driver.getOriginalDriver().findElements(this.locator);
        logger.debug(String.format("[SUCCESS]: Find '%s' multiple elements by locator: %s. Elements count found: [%d]", this.name, this.locator, elements.size()));
        return elements;
    }

    @Override
    public By getLocator() {
        return this.locator;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void click() {
        logger.info(String.format("[READY]: Click on '%s' element with locator: %s", this.name, this.locator));
        this.findElement().click();
        logger.info(String.format("[SUCCESS]: Click on '%s' element with locator: %s", this.name, this.locator));
    }

    @Override
    public boolean isDisplayed() {
        logger.info(String.format("[READY]: Get element state for '%s' element with locator: %s", this.name, this.locator));
        var isDisplayed = false;
        try {
            var elementFound = findElements().size() > 0;
            var elementDisplayed = findElement().isDisplayed();
            isDisplayed = elementFound && elementDisplayed;
        } catch (Exception exception) {
            logger.warn(String.format("[WARN]: Failed attempt to get element state for '%s' element with locator: %s. Error message: %s", this.name, this.locator, exception.getMessage()));
        }
        logger.info(String.format("[SUCCESS]: Get element state for '%s' element with locator: %s. Displayed: %s", this.name, this.locator, String.valueOf(isDisplayed)));
        return isDisplayed;
    }
}
