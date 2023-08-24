package services.element;

import org.openqa.selenium.By;

public class Text extends BaseElement {
    public Text(By locator, String name) {
        super(locator, name);
    }

    public String getTextValue()
    {
        return findElement().getText();
    }
}
