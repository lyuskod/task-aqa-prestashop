package steps;

import dto.ProductAddedModel;
import extentions.BooleanExtensions;
import helpers.AllureHelper;
import helpers.AssertHelper;
import helpers.ModelHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.platform.commons.util.ReflectionUtils;
import pages.forms.ProductAddedModalForm;
import pages.forms.ProductForm;
import pages.forms.ProductsForm;
import services.driver.AutomationService;

public class ShoppingCartSteps {
    private final ProductsForm productsForm;
    private final ProductAddedModalForm productAddedModalForm;

    public ShoppingCartSteps() {
        this.productsForm = new ProductsForm();
        this.productAddedModalForm = new ProductAddedModalForm();
    }

    @When("^I add product on the '(\\d+)' position choosing '(\\d+)' quantity to shopping cart$")
    public void addProductsToShoppingCart(int productPosition, int quantity) {
        var product = this.productsForm.selectProductByIndex(productPosition);
        product.enterQuantity(quantity);
        product.clickAddToCartBtn();
    }

    @Then("^I verify that product added modal is opened$")
    public void verifyProductAddedModalOpened() {
        AutomationService.get().browser().window().switchToDefaultContent();
        AutomationService.get().browser().window().switchToFrame("framelive");
        boolean actualState = this.productAddedModalForm.isOpened();
        AssertHelper.assertEquals(actualState, true,
                String.format("The '%s' page is %sopened", this.productAddedModalForm.getFormName(),
                        BooleanExtensions.getWording(actualState)), true);
    }

    @Then("^I verify that product has the following info on the product added modal:$")
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
