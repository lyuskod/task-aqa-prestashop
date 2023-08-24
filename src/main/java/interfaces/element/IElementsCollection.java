package interfaces.element;

import services.element.Button;
import org.openqa.selenium.By;

public interface IElementsCollection {
    Button getButton(By locator, String name);
}
