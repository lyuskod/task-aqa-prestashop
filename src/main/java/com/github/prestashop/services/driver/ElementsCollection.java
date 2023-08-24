package com.github.prestashop.services.driver;

import com.github.prestashop.services.element.*;
import com.github.prestashop.interfaces.element.IElementsCollection;
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
}
