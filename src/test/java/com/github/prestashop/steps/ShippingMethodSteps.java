package com.github.prestashop.steps;

import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.ShippingMethodPage;
import io.cucumber.java.en.When;

public class ShippingMethodSteps {

    private final ShippingMethodPage shippingMethodPage;

    public ShippingMethodSteps() {
        this.shippingMethodPage = new ShippingMethodPage();
    }

    @When("I select Click and collect on Shipping Method page")
    public void selectClickAndCollectBtn() {
        MainFrame.doInFrame(arg -> this.shippingMethodPage.selectClickAndCollectBtn());
    }

    @When("I click Continue on the Shipping Method page")
    public void clickContinueBtn() {
        MainFrame.doInFrame(arg -> this.shippingMethodPage.clickContinueBtn());
    }
}
