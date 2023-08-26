package com.github.prestashop.steps;

import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.PaymentPage;
import io.cucumber.java.en.When;

public class PaymentSteps {

    private final PaymentPage paymentPage;

    public PaymentSteps() {
        this.paymentPage = new PaymentPage();
    }

    @When("I check Terms and Conditions checkbox on Payment page")
    public void checkTermsAndConditionsCheckbox() {
        MainFrame.doInFrame(arg -> this.paymentPage.clickTermsAndConditionsCcb());
    }

    @When("I select {string} option on Payment page")
    public void selectPaymentMethod(String paymentMethod) {
        MainFrame.doInFrame(arg -> {
            var checkbox = PaymentPage.PaymentElements.parse(paymentMethod);
            paymentPage.selectPaymentMethod(checkbox);
        });
    }

    @When("I click Place Order button on Payment page")
    public void clickPlaceOrderBtn()
    {
        MainFrame.doInFrame(arg -> this.paymentPage.clickPlaceOrderBtn());
    }
}
