package services.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.driver.AutomationService;
import services.element.Label;
import org.openqa.selenium.By;

import java.time.Duration;

public abstract class BaseForm {
    private final By locator;
    private final String pageName;

    private final Label label;

    public BaseForm(By locator, String formName) {
        this.locator = locator;
        this.pageName = formName;
        this.label = new Label(locator, formName);
    }

    public By getLocator() {
        return this.locator;
    }

    public String getFormName() {
        return this.pageName;
    }

    public boolean isOpened()
    {
        return this.label.isDisplayed();
    }
}
