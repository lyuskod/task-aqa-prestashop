package com.github.prestashop.pages.pages;

import com.github.prestashop.helpers.ConditionWaiters;
import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import org.openqa.selenium.By;

import java.time.Duration;

public class ShoppingCartPage extends PageProxy {

    private final Button proceedToCheckoutBtn = AutomationService.get().elements().getButton(By.cssSelector("[class='card cart-summary'] [class='btn btn-primary']"), "Proceed to checkout");

    public ShoppingCartPage() {
        super(By.cssSelector("[class='cart-overview js-cart']"), "Shopping cart page");
    }

    public int getStoredProductsCount() {
        return AutomationService.get().elements().getElements("//ul[@class='cart-items']/li", "Stored product").size();
    }

    public void clickRemoveProductFromShoppingCart(int index) {
        var locator = String.format("(//a[@class='remove-from-cart'])[%d]", index);
        var name = String.format("Product #%d", index);
        AutomationService.get().elements().getLabel(By.xpath(locator), name).click();
        ConditionWaiters.waitUntilNotDisplayed(By.xpath(locator), Duration.ofSeconds(5));
    }

    public void clickProceedToCheckoutBtn() {
        this.proceedToCheckoutBtn.click();
    }
}
