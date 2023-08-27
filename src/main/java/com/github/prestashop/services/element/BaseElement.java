package com.github.prestashop.services.element;

import com.github.prestashop.helpers.BrowserHelper;
import com.github.prestashop.helpers.ConditionWaiters;
import com.github.prestashop.helpers.ConfigHelper;
import com.github.prestashop.helpers.JSHelper;
import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.interfaces.element.IJavaScriptActions;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement implements IBaseElement, IJavaScriptActions {
    private final By locator;

    private final String name;

    private final BaseLogger logger = BaseLogger.getLogger(BaseElement.class);

    private WebElement element;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement() {
        logger.debug(String.format("[READY]: Find '%s' element by locator: %s", this.name, this.locator));
        BrowserHelper.delay();
        this.element = Automation.get().browser().getOriginalDriver().findElement(this.locator);
        if (ConfigHelper.get().isElementHighlightEnabled()) {
            JSHelper.removeHighlightFromElement(this.element);
            JSHelper.highlightElement(this.element);
        }
        logger.debug(String.format("[SUCCESS]: Find '%s' element by locator: %s. Element is found", this.name, this.locator));
        return element;
    }

    protected List<WebElement> findElements() {
        logger.debug(String.format("[READY]: Find '%s' multiple elements by locator: %s", this.name, this.locator));
        var elements = Automation.get().browser().getOriginalDriver().findElements(this.locator);
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
        ConditionWaiters.waitUntilClickable(getLocator(), Duration.ofSeconds(10));
        this.findElement().click();
        logger.info(String.format("[SUCCESS]: Click on '%s' element with locator: %s", this.name, this.locator));
    }

    @Override
    public void jsClick() {
        logger.info(String.format("[READY]: JS-Click on '%s' element with locator: %s", this.name, this.locator));
        var element = findElement();
        var executor = (JavascriptExecutor) Automation.get().browser().getOriginalDriver();
        executor.executeScript("arguments[0].click();", element);
        logger.info(String.format("[SUCCESS]: JS-Click on '%s' element with locator: %s", this.name, this.locator));
    }

    @Override
    public boolean isDisplayed() {
        logger.info(String.format("[READY]: Get element state for '%s' element with locator: %s", this.name, this.locator));
        var isDisplayed = false;
        try {
            isDisplayed = findElement().isDisplayed();
        } catch (Exception exception) {
            logger.warn(String.format("[WARN]: Failed attempt to get element state for '%s' element with locator: %s. Error message: %s", this.name, this.locator, exception.getMessage()));
        }
        logger.info(String.format("[SUCCESS]: Get element state for '%s' element with locator: %s. Displayed: %s", this.name, this.locator, String.valueOf(isDisplayed)));
        return isDisplayed;
    }
}
