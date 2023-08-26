package com.github.prestashop.pages.pages;

import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ClothesPage extends BaseForm {
    public ClothesPage() {
        super(By.cssSelector("section#main h1"), "Clothes");
    }
}
