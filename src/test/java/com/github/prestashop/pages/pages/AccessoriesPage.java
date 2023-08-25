package com.github.prestashop.pages.pages;

import com.github.prestashop.pages.PageProxy;
import org.openqa.selenium.By;

public class AccessoriesPage extends PageProxy {
    public AccessoriesPage() {
        super(By.cssSelector("section#main h1"), "Accessories page");
    }
}
