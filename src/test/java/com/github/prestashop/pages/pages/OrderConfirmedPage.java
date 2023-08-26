package com.github.prestashop.pages.pages;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class OrderConfirmedPage extends BaseForm {
    public OrderConfirmedPage() {
        super(By.cssSelector("#content-hook_order_confirmation"), "Order confirmed");
    }

    public int getOrderedItemsCount() {
        return Automation.get()
                .elements()
                .getElements("//*[@class='order-confirmation-table']/div[@class='order-line row']",
                        "Ordered products")
                .size();
    }
}
