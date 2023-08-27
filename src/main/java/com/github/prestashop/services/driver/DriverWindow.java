package com.github.prestashop.services.driver;

import com.github.prestashop.interfaces.driver.IDriverWindow;
import com.github.prestashop.services.logger.BaseLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;

import java.util.function.Consumer;

public class DriverWindow implements IDriverWindow {
    private final BaseLogger logger;
    private final WebDriver driver;
    private final Window window;

    public DriverWindow(WebDriver driver) {
        this.driver = driver;
        this.window = driver.manage().window();
        this.logger = BaseLogger.getLogger(DriverWindow.class);
    }

    @Override
    public void setFullScreen() {
        logger.info("[READY]: Set browser screen mode to fullscreen");
        this.window.fullscreen();
        logger.info("[SUCCESS]: Set browser screen mode to fullscreen");
    }

    @Override
    public void setMaximize() {
        logger.info("[READY]: Set browser screen mode to fullscreen");
        this.window.maximize();
        logger.info("[SUCCESS]: Set browser screen mode to fullscreen");
    }

    @Override
    public byte[] getScreenshot() {
        logger.info("[READY]: Take screenshot");
        var bytes = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        logger.info("[SUCCESS]: Take screenshot");
        return bytes;
    }

    @Override
    public void switchToFrame(String nameOrIdCss) {
        logger.info(String.format("[READY]: Switch to frame with '%s' name/id", nameOrIdCss));
        this.driver.switchTo().frame(nameOrIdCss);
        logger.info(String.format("[SUCCESS]: Switch to frame with '%s' name/id", nameOrIdCss));
    }

    @Override
    public void switchToDefaultContent() {
        logger.info("[READY]: Switch to default content");
        this.driver.switchTo().defaultContent();
        logger.info("[SUCCESS]: Switch to default content");
    }

    @Override
    public void doInFrame(String nameOrIdCss, Consumer<String> action) {
        logger.info(String.format("[READY]: Do actions inside the frame with '%s' name/id", nameOrIdCss));
        switchToFrame(nameOrIdCss);
        action.accept(nameOrIdCss);
        switchToDefaultContent();
    }
}
