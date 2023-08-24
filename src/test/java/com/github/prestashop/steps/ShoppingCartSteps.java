package com.github.prestashop.steps;

import com.github.prestashop.dto.ProductAddedModel;
import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.helpers.ModelHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.prestashop.pages.forms.ProductAddedModalForm;
import com.github.prestashop.pages.forms.ProductsForm;
import com.github.prestashop.services.driver.AutomationService;

public class ShoppingCartSteps {
    private final ProductsForm productsForm;
    private final ProductAddedModalForm productAddedModalForm;

    public ShoppingCartSteps() {
        this.productsForm = new ProductsForm();
        this.productAddedModalForm = new ProductAddedModalForm();
    }

    @When("I add product on the '{int}' position choosing '{int}' as quantity to shopping cart")
    public void addProductsToShoppingCart(int productPosition, int quantity) {
        var product = this.productsForm.selectProductByIndex(productPosition);
        product.enterQuantity(quantity);
        product.clickAddToCartBtn();
    }

    @Then("I verify that product added modal is opened")
    public void verifyProductAddedModalOpened() {
        AutomationService.get().browser().window().switchToDefaultContent();
        AutomationService.get().browser().window().switchToFrame("framelive");
        boolean actualState = this.productAddedModalForm.isOpened();
        AssertHelper.assertEquals(actualState, true,
                String.format("The '%s' page is %sopened", this.productAddedModalForm.getFormName(),
                        BooleanExtensions.getWording(actualState)), true);
    }

    @Then("I verify that product has the following info on the product added modal:")
    public void verifyProductAddedModalProductInfo() {
        var productModel = new ProductAddedModel();
        productModel.setQuantity(2);
        ModelHelper.getClassAttributesValues(productModel.getClass()).entrySet().forEach((stringObjectEntry -> {
            var attributeName = stringObjectEntry.getKey();
            var expectedAttributeValue = (String) stringObjectEntry.getValue();
            var actualAttributeValue = this.productAddedModalForm.getAttributeValue(attributeName);
            AssertHelper.assertEquals(actualAttributeValue, expectedAttributeValue,
                    String.format("Attribute value '%s' of added product is not equal to expected value"), false);
        }));
        AllureHelper.takeAndAttachScreenShot();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
