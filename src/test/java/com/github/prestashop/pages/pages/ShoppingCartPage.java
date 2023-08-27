package com.github.prestashop.pages.pages;

import com.github.prestashop.helpers.ConditionWaiters;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

import java.time.Duration;

public class ShoppingCartPage extends BaseForm {

    private final Button proceedToCheckoutBtn = Automation.get()
            .elements()
            .getButton(By.cssSelector("[class='card cart-summary'] [class='btn btn-primary']"), "\"Proceed to checkout\" button");

    public ShoppingCartPage() {
        super(By.cssSelector("[class='cart-overview js-cart']"), "Shopping cart page");
    }

    public int getStoredProductsCount() {
        return Automation.get()
                .elements()
                .getElements("//ul[@class='cart-items']/li", "Stored product")
                .size();
    }

    public void removeProductFromShoppingCart(int index) {
        var locator = String.format("(//a[@class='remove-from-cart'])[%d]", index);
        var name = String.format("Product #%d", index);
        Automation.get().elements().getLabel(By.xpath(locator), name).click();
        ConditionWaiters.waitUntilNotDisplayed(By.xpath(locator), Duration.ofSeconds(1));
    }

    public void proceedToCheckout() {
        this.proceedToCheckoutBtn.click();
    }
}
