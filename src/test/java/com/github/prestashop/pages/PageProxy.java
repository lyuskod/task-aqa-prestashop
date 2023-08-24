package com.github.prestashop.pages;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public abstract class PageProxy extends BaseForm {
    public PageProxy(By locator, String formName) {
        super(locator, formName);
    }
}
