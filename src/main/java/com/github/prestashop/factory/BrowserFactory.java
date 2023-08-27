package com.github.prestashop.factory;

import com.github.prestashop.helpers.ConfigHelper;
import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.services.driver.RemoteDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserFactory {
    private BrowserFactory() {
    }

    public static BaseDriver getDriver(String browserName) {
        BaseDriver driver = null;
        var options = OptionsFactory.getOptions(browserName);
        var browserVersion = ConfigHelper.get().getVersion();

        if (ConfigHelper.get().getRemote().isEnabled()) {
            var webDriver = getRemoteWebDriver(options);
            return new RemoteDriver(webDriver);
        }

        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
                var webDriver = new ChromeDriver((ChromeOptions) options);
                driver = new com.github.prestashop.services.driver.ChromeDriver(webDriver);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();
                var webDriver = new FirefoxDriver((FirefoxOptions) options);
                driver = new com.github.prestashop.services.driver.FirefoxDriver(webDriver);
            }
            default -> {
                throw new IllegalArgumentException(String.format("Browser '%s' is not supported", browserName));
            }
        }
        return driver;
    }

    private static WebDriver getRemoteWebDriver(AbstractDriverOptions options) {
        var url = ConfigHelper.get().getRemote().getUrl();
        final var browser = ConfigHelper.get().getBrowserName();
        var remoteUrl = ConfigHelper.get().getRemote().getUrl();
        return switch (browser) {
            case "chrome" -> WebDriverManager.chromedriver()
                    .capabilities(options)
                    .remoteAddress(remoteUrl)
                    .create();
            case "firefox" -> WebDriverManager.firefoxdriver()
                    .capabilities(options)
                    .remoteAddress(remoteUrl)
                    .create();
            default ->
                    throw new IllegalArgumentException(String.format("Remote '%s' browser is not supported", browser));
        };
    }
}
