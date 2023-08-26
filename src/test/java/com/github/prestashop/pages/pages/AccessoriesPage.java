package com.github.prestashop.pages.pages;

import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class AccessoriesPage extends BaseForm {
    public AccessoriesPage() {
        super(By.cssSelector("section#main h1"), "Accessories");
    }
}
