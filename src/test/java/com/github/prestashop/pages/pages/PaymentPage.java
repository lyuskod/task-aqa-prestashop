package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.ClickableCheckBox;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PaymentPage extends BaseForm {
    private final ClickableCheckBox termsAndConditionsClickableCheckBox = Automation.get()
            .elements()
            .getClickableCheckbox(By.cssSelector("input[id^='conditions_to_approve']"), "\"Terms and Conditions\" checkbox");

    private final ClickableCheckBox payByBankWireClickableCheckBox = Automation.get()
            .elements()
            .getClickableCheckbox(By.cssSelector("#payment-option-1-container span"), "\"Pay by bank wire\" checkbox");

    private final Button placeOrderButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("#payment-confirmation button"), "\"Place order\" button");

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

    private final HashMap<String, ClickableCheckBox> clickableCheckboxes = new HashMap<>() {
        {
            put(PaymentElements.Pay_by_bank_wire.elementName, payByBankWireClickableCheckBox);
        }
    };

    public void checkTermsAndConditionsCheckbox() {
        this.termsAndConditionsClickableCheckBox.jsClick();
    }

    public void selectPaymentMethod(PaymentElements checkbox) {
        clickableCheckboxes.get(checkbox.elementName).click();
    }

    public void clickPlaceOrderBtn() {
        this.placeOrderButton.click();
    }
}

