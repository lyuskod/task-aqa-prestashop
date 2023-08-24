package com.github.prestashop.pages.pages;

import com.github.prestashop.pages.PageProxy;
import org.openqa.selenium.By;
import com.github.prestashop.pages.forms.TopMenu;

public class MainPage extends PageProxy {

    private final TopMenu topMenu;

    public MainPage() {
        super(By.cssSelector("section[class='featured-products clearfix']"), "Popular Products");
        this.topMenu = new TopMenu();
    }

    public TopMenu topMenu() {
        return this.topMenu;
    }
}
