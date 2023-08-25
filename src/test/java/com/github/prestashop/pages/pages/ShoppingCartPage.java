package com.github.prestashop.pages.pages;

import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.Label;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingCartPage extends PageProxy {

    public ShoppingCartPage() {
        super(By.cssSelector("[class='cart-overview js-cart']"), "Shopping cart page");
    }

    public int getStoredProductsCount() {
        return AutomationService.get().elements().getElements("//ul[@class='cart-items']/li", "Stored product").size();
    }
}
