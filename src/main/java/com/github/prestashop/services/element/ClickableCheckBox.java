package com.github.prestashop.services.element;

import com.github.prestashop.interfaces.element.IClickableElement;
import org.openqa.selenium.By;

public class ClickableCheckBox extends CheckBox implements IClickableElement {
    public ClickableCheckBox(By locator, String name) {
        super(locator, name);
    }
}
