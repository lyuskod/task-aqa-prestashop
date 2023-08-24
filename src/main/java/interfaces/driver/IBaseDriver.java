package interfaces.driver;

import services.driver.DriverSession;
import services.driver.DriverTimeouts;
import services.driver.DriverWindow;
import services.driver.DriverWindowHandles;

public interface IBaseDriver {
    void go(String url);
    DriverWindow window();
    DriverTimeouts timeouts();
    DriverWindowHandles windowHandles();
    DriverSession session();
}
