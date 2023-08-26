package com.github.prestashop.pages.pages;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.Label;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ShippingMethodPage extends BaseForm {

    private final Label clickAndCollectLbl = AutomationService.get()
            .elements().getLabel(By.cssSelector("[for='delivery_option_1']"), "Click and collect");

    private final Button continueBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("button[name='confirmDeliveryOption']"), "Continue");

    public ShippingMethodPage() {
        super(By.cssSelector("#checkout-delivery-step"), "Shipping method");
    }

    public void selectClickAndCollectBtn()
    {
        this.clickAndCollectLbl.click();
    }

    public void clickContinueBtn()
    {
        this.continueBtn.click();
    }
}
