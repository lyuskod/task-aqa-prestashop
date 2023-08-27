package com.github.prestashop.factory;

import com.github.prestashop.services.driver.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private BrowserFactory() {
    }

    public static BaseDriver getDriver(String browserName) {
        BaseDriver driver = null;
        var options = OptionsFactory.getOptions(browserName);
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                var webDriver = new ChromeDriver((ChromeOptions) options);
                driver = new com.github.prestashop.services.driver.ChromeDriver(webDriver);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                var webDriver = new FirefoxDriver((FirefoxOptions) options);
                driver = new com.github.prestashop.services.driver.FirefoxDriver(webDriver);
            }
            default -> {
                throw new IllegalArgumentException(String.format("Browser '%s' is not supported", browserName));
            }
        }
        return driver;
    }
}
