package com.github.prestashop.steps;

import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.OrderConfirmedPage;
import io.cucumber.java.en.Then;

public class OrderConfirmedSteps {

    private final OrderConfirmedPage orderConfirmedPage;

    public OrderConfirmedSteps()
    {
        this.orderConfirmedPage = new OrderConfirmedPage();
    }

    @Then("I verify that '(\\d+)' product(?:s|) (?:is |are )stored in ordered products table on Order confirmed page$")
    public void verifyShoppingCartStoredProducts(int expectedOrderedProductsCount) {
        MainFrame.doInFrame(arg -> {
            var actualOrderedProductsCount = this.orderConfirmedPage.getOrderedItemsCount();
            AssertHelper.assertEquals(actualOrderedProductsCount, expectedOrderedProductsCount,
                    String.format("Expected ordered products count in products table to eq %d", expectedOrderedProductsCount), true);
        });
    }
}
