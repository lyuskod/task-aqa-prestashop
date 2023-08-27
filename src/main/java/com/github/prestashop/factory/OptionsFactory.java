package com.github.prestashop.factory;

import com.github.prestashop.helpers.ConfigHelper;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class OptionsFactory {
    private OptionsFactory() {
    }

    public static AbstractDriverOptions getOptions(String browserName) {
        AbstractDriverOptions options = null;
        switch (browserName) {
            case "firefox" -> {
                options = getFireFoxOptions();
            }
            case "chrome" -> {
                options = getChromeOptions();
            }
            default -> {
                throw new IllegalArgumentException(String.format("Browser '%s' is not supported.", browserName));
            }
        }
        return options;
    }

    private static ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments(ConfigHelper.get().getOptions());
        return options;
    }

    private static FirefoxOptions getFireFoxOptions() {
        var options = new FirefoxOptions();
        options.addArguments(ConfigHelper.get().getOptions());
        return options;
    }
}
