package com.github.prestashop.steps;

import com.github.prestashop.helpers.ElementsHelper;
import com.github.prestashop.helpers.models.ElementModel;
import com.github.prestashop.helpers.StringHelper;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.pages.forms.NavigationMenuForm;
import com.github.prestashop.pages.forms.ProductAddedModalForm;
import com.github.prestashop.pages.forms.ProductOverviewForm;
import com.github.prestashop.pages.forms.ProductsForm;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ShoppingCartSteps {
    private final ProductsForm productsForm;
    private final ProductOverviewForm productOverviewForm;
    private final ProductAddedModalForm productAddedModalForm;
    private final NavigationMenuForm navigationMenuForm;
    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        this.productsForm = new ProductsForm();
        this.productAddedModalForm = new ProductAddedModalForm();
        this.navigationMenuForm = new NavigationMenuForm();
        this.shoppingCartPage = new ShoppingCartPage();
        this.productOverviewForm = new ProductOverviewForm();
    }

    @When("I add product on the '{int}' position choosing '{int}' as quantity to shopping cart")
    public void addProductsToShoppingCart(int productPosition, int quantity) {
        MainFrame.doInFrame((arg) -> {
            productsForm.selectProductByIndex(productPosition);
            productOverviewForm.enterQuantity(quantity);
            productOverviewForm.addToCart();
        });
    }

    @Then("I verify that product has the following info on the product added modal:")
    public void verifyProductAddedModalProductInfo(List<ElementModel> expectedData) {
        MainFrame.doInFrame(arg -> ElementsHelper.verifyElements(productAddedModalForm, expectedData));
        AllureHelper.takeAndAttachScreenShot();
    }

    @When("I click Continue Shopping button on Product Added modal window")
    public void closeProductAddedModalWindow() {
        MainFrame.doInFrame(arg -> productAddedModalForm.continueShopping());
    }

    @When("I click Proceed to Checkout button on Product Added modal window")
    public void closeProceedToCheckoutModalWindow() {
        MainFrame.doInFrame(arg -> productAddedModalForm.proceedToCheckout());
    }

    @Then("I verify that Cart displays '{int}' as products added to Shopping Cart")
    public void verifyCartProductsCount(int expectedCartProductsCount) {
        MainFrame.doInFrame(arg -> {
            var actualCartProductsCount = StringHelper.extractNumberFromString(this.navigationMenuForm.getCartProductsCount());
            AssertHelper.assertEquals(actualCartProductsCount, expectedCartProductsCount,
                    String.format("Expected Cart product count to eq %d", expectedCartProductsCount), true);
        });
    }

    @When("I click on '(Cart|Language|Sign in)' navigation menu item$")
    public void selectNavigationMenuItemStep(String navMenuItem) {
        MainFrame.doInFrame(arg -> {
            var element = NavigationMenuForm.ProductCategories.parse(navMenuItem);
            this.navigationMenuForm.openProductCategory(element);
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
        MainFrame.doInFrame(arg -> indexes.forEach(shoppingCartPage::removeProductFromShoppingCart));
    }

    @When("I click Proceed to Checkout button on Shopping Cart")
    public void clickProceedToCheckoutBtn() {
        MainFrame.doInFrame(arg -> shoppingCartPage.proceedToCheckout());
    }
}
