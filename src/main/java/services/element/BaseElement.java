package services.element;

import services.driver.AutomationService;
import services.driver.BaseDriver;
import interfaces.element.IBaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement implements IBaseElement {

    private final By locator;
    private final String name;

    protected BaseDriver driver;

    public BaseElement(By locator, String name) {
        this.driver = AutomationService.get().browser();
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement()
    {
        return this.driver.getOriginDriver().findElement(this.locator);
    }

    public By getLocator() {
        return this.locator;
    }

    public String getName() {
        return this.name;
    }

    public void click() {
        this.findElement().click();
    }

    public boolean isDisplayed()
    {
        return this.findElement().isDisplayed();
    }
}
