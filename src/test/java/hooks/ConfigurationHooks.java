package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ConfigurationHooks {

    private final WebDriver driver;

    public ConfigurationHooks()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Before
    public void setup()
    {

        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
        driver.get("https://demo.prestashop.com/#/en/front");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
