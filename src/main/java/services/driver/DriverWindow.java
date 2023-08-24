package services.driver;

import interfaces.driver.IDriverWindow;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;

public class DriverWindow implements IDriverWindow {

    private final WebDriver driver;
    private final Window window;

    public DriverWindow(WebDriver driver) {
        this.driver = driver;
        this.window = driver.manage().window();
    }

    @Override
    public void setFullScreen() {
        this.window.fullscreen();
    }

    @Override
    public byte[] getScreenshot() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void switchToFrame(String nameOrIdCss) {
        this.driver.switchTo().frame(nameOrIdCss);
    }

    @Override
    public void switchToDefaultContent() {
        this.driver.switchTo().defaultContent();
    }
}
