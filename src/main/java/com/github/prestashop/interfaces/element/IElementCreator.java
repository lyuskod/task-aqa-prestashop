package com.github.prestashop.interfaces.element;

import com.github.prestashop.services.element.*;
import org.openqa.selenium.By;

import java.util.List;

public interface IElementCreator<T> {
    Button getButton(By locator, String name);

    Label getLabel(By locator, String name);

    MenuItem getMenuItem(By locator, String name);

    Text getTextElement(By locator, String name);

    TextBox getTextBox(By locator, String name);

    DropDown getDropDown(By locator, String name);

    CheckBox getCheckBox(By locator, String name);

    RadioButton getRadioButton(By locator, String name);

    ClickableCheckBox getClickableCheckbox(By locator, String name);

    ClickableRadioButton getClickableRadioButton(By locator, String name);

    List<BaseElement> getElements(String xpath, String name);
}
