package com.github.prestashop.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class OptionsFactory {
    private OptionsFactory() {
    }

    public static AbstractDriverOptions getOptions(String browserName) {
        AbstractDriverOptions options = null;
        switch (browserName) {
            case "firefox": {
                options = getFireFoxOptions();
                break;
            }
            case "chrome": {
                options = getChromeOptions();
                break;
            }
            default: {
                throw new IllegalArgumentException(String.format("Browser '%s' is not supported.", browserName));
            }
        }
        return options;
    }

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    private static FirefoxOptions getFireFoxOptions() {
        return new FirefoxOptions();
    }
}
