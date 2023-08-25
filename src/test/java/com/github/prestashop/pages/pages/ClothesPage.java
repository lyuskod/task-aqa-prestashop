package com.github.prestashop.pages.pages;

import com.github.prestashop.pages.PageProxy;
import org.openqa.selenium.By;

public class ClothesPage extends PageProxy {
    public ClothesPage() {
        super(By.cssSelector("section#main h1"), "Clothes page");
    }
}
