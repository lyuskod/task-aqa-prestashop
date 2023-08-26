package com.github.prestashop.services.element;

import com.github.prestashop.interfaces.element.IClickableElement;
import org.openqa.selenium.By;

public class ClickableRadioButton extends BaseElement implements IClickableElement {
    public ClickableRadioButton(By locator, String name) {
        super(locator, name);
    }
}
