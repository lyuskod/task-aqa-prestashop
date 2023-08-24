package services.driver;

import services.element.Button;
import interfaces.element.IElementsCollection;
import org.openqa.selenium.By;

public class ElementsCollection implements IElementsCollection {
    private final BaseDriver driver;

    public ElementsCollection(BaseDriver driver) {
        this.driver = driver;
    }

    @Override
    public Button getButton(By locator, String name) {
        return new Button(locator, name);
    }
}
