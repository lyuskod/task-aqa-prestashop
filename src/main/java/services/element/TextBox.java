package services.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends BaseElement{

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void clearAndType(String content)
    {
        var element = findElement();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(content);
    }
}
