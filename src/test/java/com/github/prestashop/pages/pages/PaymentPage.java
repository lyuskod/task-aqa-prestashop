package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.ClickableCheckbox;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PaymentPage extends BaseForm {

    private final ClickableCheckbox termsAndConditionsCcb = AutomationService.get()
            .elements().getClickableCheckbox(By.cssSelector("input[id^='conditions_to_approve']"), "Terms and Conditions");

    private final ClickableCheckbox payByBankWireCcb = AutomationService.get()
            .elements().getClickableCheckbox(By.cssSelector("#payment-option-1-container span"), "Pay by bank wire");

    private final Button placeOrderBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("#payment-confirmation button"), "Place order");

    public PaymentPage() {
        super(By.cssSelector("#checkout-payment-step"), "Payment");
    }

    @AllArgsConstructor
    public enum PaymentElements implements IEnumParser {
        Pay_by_bank_wire("Pay by bank wire");

        @Getter
        private final String elementName;

        public static PaymentPage.PaymentElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, ClickableCheckbox> clickableCheckboxes = new HashMap<>() {
        {
            put(PaymentElements.Pay_by_bank_wire.elementName, payByBankWireCcb);
        }
    };

    public void clickTermsAndConditionsCcb() {
        this.termsAndConditionsCcb.jsClick();
    }

    public void selectPaymentMethod(PaymentElements checkbox)
    {
        clickableCheckboxes.get(checkbox.elementName).click();
    }

    public void clickPlaceOrderBtn()
    {
        this.placeOrderBtn.click();
    }
}

