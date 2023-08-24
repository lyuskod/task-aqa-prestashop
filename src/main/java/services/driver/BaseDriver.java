package services.driver;

import interfaces.driver.IBaseDriver;
import org.openqa.selenium.WebDriver;

public abstract class BaseDriver implements IBaseDriver {
    private final WebDriver driver;
    private final DriverWindow window;
    private final DriverTimeouts timeouts;
    private final DriverWindowHandles windowHandles;
    private final DriverSession session;

    public BaseDriver(WebDriver driver) {
        this.driver = driver;
        this.window = new DriverWindow(this.driver);
        this.timeouts = new DriverTimeouts(this.driver);
        this.windowHandles = new DriverWindowHandles(this.driver);
        this.session = new DriverSession(this.driver);
    }


    public DriverWindow window() {
        return this.window;
    }

    public DriverTimeouts timeouts() {
        return this.timeouts;
    }

    public DriverWindowHandles windowHandles() {
        return this.windowHandles;
    }

    public DriverSession session() {
        return this.session;
    }

    public void go(String url)
    {
        this.driver.get(url);
    }

    public WebDriver getOriginDriver()
    {
        return this.driver;
    }
}
