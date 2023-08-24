package services.driver;

import interfaces.driver.IDriverWindowHandles;
import org.openqa.selenium.WebDriver;

public class DriverWindowHandles implements IDriverWindowHandles {

    private final WebDriver driver;

    public DriverWindowHandles(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCurrentTab() {
        this.driver.close();
    }
}
