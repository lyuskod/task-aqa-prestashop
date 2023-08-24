package com.github.prestashop.steps;

import com.github.prestashop.cucumber.ElementsHelper;
import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.pages.forms.ProductAddedModalForm;
import com.github.prestashop.pages.forms.ProductsForm;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

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

    @Then("I verify that product has the following info on the product added modal:")
    public void verifyProductAddedModalProductInfo(List<ElementDto> expectedData) {
        ElementsHelper.verifyElements(new ProductAddedModalForm(), expectedData);
        AllureHelper.takeAndAttachScreenShot();
    }
}
