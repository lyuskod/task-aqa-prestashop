package com.github.prestashop.services.element;

import com.github.prestashop.interfaces.element.IClickableElement;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ClickableCheckbox extends BaseElement implements IClickableElement {
    public ClickableCheckbox(By locator, String name) {
        super(locator, name);
    }
}
