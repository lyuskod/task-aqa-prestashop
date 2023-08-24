package services.element;

import org.openqa.selenium.By;

public class Label extends BaseElement {
    public Label(By locator) {
        super(locator, "Label");
    }

    public Label(By locator, String name) {
        super(locator, name);
    }
}
