package com.github.prestashop.pages.pages;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.ClickableRadioButton;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ShippingMethodPage extends BaseForm {

    private final ClickableRadioButton clickAndCollectRadioButton = Automation.get()
            .elements()
            .getClickableRadioButton(By.cssSelector("[for='delivery_option_1']"), "\"Click and collect\" radio button");

    private final Button continueButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("button[name='confirmDeliveryOption']"), "\"Continue\" button");

    public ShippingMethodPage() {
        super(By.cssSelector("#checkout-delivery-step"), "Shipping method");
    }

    public void selectClickAndCollectShippingMethod()
    {
        this.clickAndCollectRadioButton.click();
    }

    public void clickContinueBtn()
    {
        this.continueButton.click();
    }
}
