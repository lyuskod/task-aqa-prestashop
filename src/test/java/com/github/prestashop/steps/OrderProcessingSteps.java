package com.github.prestashop.steps;

import com.github.prestashop.helpers.ElementsHelper;
import com.github.prestashop.helpers.models.ElementModel;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class OrderProcessingSteps {
    private final AddressesPage addressesPage;

    private final PaymentPage paymentPage;

    private final OrderConfirmedPage orderConfirmedPage;

    private final PersonalInformationPage personalInformationPage;

    private final ShippingMethodPage shippingMethodPage;

    public OrderProcessingSteps() {
        this.addressesPage = new AddressesPage();
        this.paymentPage = new PaymentPage();
        this.orderConfirmedPage = new OrderConfirmedPage();
        this.personalInformationPage = new PersonalInformationPage();
        this.shippingMethodPage = new ShippingMethodPage();
    }

    @When("I configure the Addresses page as follows:")
    public void configureAddressesPage(List<ElementModel> elements) {
        MainFrame.doInFrame(arg -> ElementsHelper.configureElements(addressesPage, elements));
        AllureHelper.takeAndAttachScreenShot();
    }

    @When("I click Continue on the Addresses page")
    public void clickContinueBtnOnAddressesPage() {
        MainFrame.doInFrame(arg -> this.addressesPage.clickContinueBtn());
    }

    @When("I check Terms and Conditions checkbox on Payment page")
    public void checkTermsAndConditionsCheckbox() {
        MainFrame.doInFrame(arg -> this.paymentPage.checkTermsAndConditionsCheckbox());
    }

    @When("I select {string} option on Payment page")
    public void selectPaymentMethod(String paymentMethod) {
        MainFrame.doInFrame(arg -> {
            var checkbox = PaymentPage.PaymentElements.parse(paymentMethod);
            paymentPage.selectPaymentMethod(checkbox);
        });
    }

    @When("I click Place Order button on Payment page")
    public void clickPlaceOrderBtn() {
        MainFrame.doInFrame(arg -> this.paymentPage.clickPlaceOrderBtn());
    }

    @Then("I verify that '(\\d+)' product(?:s|) (?:is |are )stored in ordered products table on Order confirmed page$")
    public void verifyShoppingCartStoredProducts(int expectedOrderedProductsCount) {
        MainFrame.doInFrame(arg -> {
            var actualOrderedProductsCount = this.orderConfirmedPage.getOrderedItemsCount();
            AssertHelper.assertEquals(actualOrderedProductsCount, expectedOrderedProductsCount,
                    String.format("Expected ordered products count in products table to eq %d", expectedOrderedProductsCount), true);
        });
    }

    @When("I configure the Personal Information page as follows:")
    public void configurePersonalInformation(List<ElementModel> elements) {
        MainFrame.doInFrame(arg -> {
            ElementsHelper.configureElements(personalInformationPage, elements);
        });
        AllureHelper.takeAndAttachScreenShot();
    }

    @When("I click Continue button on Personal Information page")
    public void clickContinueBtnOnPersonalInformation() {
        MainFrame.doInFrame(arg -> personalInformationPage.clickContinueBtn());
    }

    @When("I select Click and collect on Shipping Method page")
    public void selectClickAndCollectBtn() {
        MainFrame.doInFrame(arg -> this.shippingMethodPage.selectClickAndCollectShippingMethod());
    }

    @When("I click Continue on the Shipping Method page")
    public void clickContinueBtn() {
        MainFrame.doInFrame(arg -> this.shippingMethodPage.clickContinueBtn());
    }
}
