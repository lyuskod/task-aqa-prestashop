package com.github.prestashop.pages.pages;

import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ArtPage extends BaseForm {
    public ArtPage() {
        super(By.cssSelector("section#main h1"), "Art");
    }
}
