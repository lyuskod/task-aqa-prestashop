package com.github.prestashop.pages.pages;

import com.github.prestashop.pages.PageProxy;
import org.openqa.selenium.By;

public class ArtPage extends PageProxy {
    public ArtPage() {
        super(By.cssSelector("section#main h1"), "Art page");
    }
}
