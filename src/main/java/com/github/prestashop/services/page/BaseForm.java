package com.github.prestashop.services.page;

import com.github.prestashop.interfaces.form.IBaseForm;
import com.github.prestashop.services.element.Label;
import org.openqa.selenium.By;

public abstract class BaseForm implements IBaseForm {
    private final By locator;

    private final String pageName;

    private final Label label;

    public BaseForm(By locator, String formName) {
        this.locator = locator;
        this.pageName = formName;
        this.label = new Label(locator, formName);
    }

    @Override
    public By getLocator() {
        return this.locator;
    }

    @Override
    public String getFormName() {
        return this.pageName;
    }

    @Override
    public boolean isOpened() {
        return this.label.isDisplayed();
    }
}
