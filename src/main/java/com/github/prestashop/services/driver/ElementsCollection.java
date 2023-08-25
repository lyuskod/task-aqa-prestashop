package com.github.prestashop.services.driver;

import com.github.prestashop.services.element.*;
import com.github.prestashop.interfaces.element.IElementsCollection;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ElementsCollection<T extends BaseElement> implements IElementsCollection {
    private final BaseDriver driver;

    public ElementsCollection(BaseDriver driver) {
        this.driver = driver;
    }

    @Override
    public Button getButton(By locator, String name) {
        return new Button(locator, name);
    }

    @Override
    public Label getLabel(By locator, String name) {
        return new Label(locator, name);
    }

    @Override
    public MenuItem getMenuItem(By locator, String name) {
        return new MenuItem(locator, name);
    }

    @Override
    public Text getTextElement(By locator, String name) {
        return new Text(locator, name);
    }

    @Override
    public TextBox getTextBox(By locator, String name) {
        return new TextBox(locator, name);
    }

    @Override
    public List<T> getElements(String xPath, String name) {
        var baseElements = new ArrayList<T>();
        var webElements = this.driver.getOriginalDriver().findElements(By.xpath(xPath));
        for (var index = 0; index < webElements.size(); index++) {
            var baseElementLocator = String.format("(%s)[%d]", xPath, index + 1);
            var baseElementName = String.format("%s [%d]", name, index + 1);
            var baseElement = (T) (new Label(By.xpath(baseElementLocator), baseElementName));
            baseElements.add(baseElement);
        }
        return baseElements;
    }

}
