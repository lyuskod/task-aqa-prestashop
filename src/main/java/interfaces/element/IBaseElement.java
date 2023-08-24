package interfaces.element;

import org.openqa.selenium.By;

public interface IBaseElement {

    By getLocator();
    String getName();
    void click();
    boolean isDisplayed();
}
