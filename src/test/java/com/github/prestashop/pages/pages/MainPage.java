package com.github.prestashop.pages.pages;

import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;
import com.github.prestashop.pages.forms.TopMenu;

public class MainPage extends BaseForm {
    public MainPage() {
        super(By.cssSelector("section[class='featured-products clearfix']"), "Main");
    }
}
