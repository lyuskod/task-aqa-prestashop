package com.github.prestashop.steps;

import com.github.prestashop.cucumber.ElementsHelper;
import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.dto.ProductModelDto;
import com.github.prestashop.extensions.StringExtensions;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.pages.forms.NavigationMenuForm;
import com.github.prestashop.pages.forms.ProductAddedModalForm;
import com.github.prestashop.pages.forms.ProductsForm;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.ShoppingCartPage;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ShoppingCartSteps {
    private final ProductsForm productsForm;
    private final ProductAddedModalForm productAddedModalForm;
    private final NavigationMenuForm navigationMenuForm;

    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        this.productsForm = new ProductsForm();
        this.productAddedModalForm = new ProductAddedModalForm();
        this.navigationMenuForm = new NavigationMenuForm();
        this.shoppingCartPage = new ShoppingCartPage();
    }

    @When("I add product on the '{int}' position choosing '{int}' as quantity to shopping cart")
    public void addProductsToShoppingCart(int productPosition, int quantity) {
        MainFrame.doInFrame((arg) -> {
            var product = this.productsForm.selectProductByIndex(productPosition);
            product.enterQuantity(quantity);
            product.clickAddToCartBtn();
        });
    }

    @Then("I verify that product has the following info on the product added modal:")
    public void verifyProductAddedModalProductInfo(List<ElementDto> expectedData) {
        MainFrame.doInFrame((arg) -> {
            ElementsHelper.verifyElements(new ProductAddedModalForm(), expectedData);
            AllureHelper.takeAndAttachScreenShot();
        });
    }

    @When("I click Continue Shopping button on Product Added modal window")
    public void closeProductAddedModalWindow() {
        MainFrame.doInFrame(arg -> this.productAddedModalForm.clickContinueShopping());
    }

    @Then("I verify that Cart displays '{int}' as products added to Shopping Cart")
    public void verifyCartProductsCount(int expectedCartProductsCount) {
        MainFrame.doInFrame(arg -> {
            var actualCartProductsCount = StringExtensions.extractNumberFromString(this.navigationMenuForm.getCurrentCartProductsCount());
            AssertHelper.assertEquals(actualCartProductsCount, expectedCartProductsCount,
                    String.format("Expected Cart product count to eq %d", expectedCartProductsCount), true);
        });
    }

    @When("I click on '(Cart|Language|Sign in)' navigation menu item$")
    public void selectNavigationMenuItemStep(String navMenuItem) {
        MainFrame.doInFrame(arg -> {
            var element = NavigationMenuForm.NavigationMenuElements.parse(navMenuItem);
            this.navigationMenuForm.clickNavigationMenuItem(element);
        });
    }

    @Then("I verify that '(\\d+)' product(?:s|) (?:is |are )stored in Shopping Cart$")
    public void verifyShoppingCartStoredProducts(int expectedCartProductsCount) {
        MainFrame.doInFrame(arg -> {
            var actualCartProductsCount = this.shoppingCartPage.getStoredProductsCount();
            AssertHelper.assertEquals(actualCartProductsCount, expectedCartProductsCount,
                    String.format("Expected products added to shopping cart count to eq %d", expectedCartProductsCount), true);
        });
    }

    @When("I remove products on the following positions from my Shopping Cart:")
    public void removeProductsFromShoppingCartByIndexes(List<Integer> indexes) {
        MainFrame.doInFrame(arg -> indexes.forEach(shoppingCartPage::clickRemoveProductFromShoppingCart));
    }
}
