package services.driver;

import interfaces.driver.IDriverSession;
import org.openqa.selenium.WebDriver;

public class DriverSession implements IDriverSession {

    private final WebDriver driver;

    public DriverSession(WebDriver driver)
    {
        this.driver = driver;
    }

    public void end()
    {
        this.driver.quit();
    }
}
