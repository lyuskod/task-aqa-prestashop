package com.github.prestashop.interfaces.element;

import com.github.prestashop.services.element.*;
import org.openqa.selenium.By;

public interface IElementsCollection {
    Button getButton(By locator, String name);

    Label getLabel(By locator, String name);

    MenuItem getMenuItem(By locator, String name);

    Text getTextElement(By locator, String name);

    TextBox getTextBox(By locator, String name);
}
