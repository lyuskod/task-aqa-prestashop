package com.github.prestashop.pages.forms;

import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Text;
import com.github.prestashop.services.page.BaseForm;

import java.util.HashMap;

public class ProductAddedModalForm extends PageProxy implements IElementsHelper {

    private final Text quantityTxt = AutomationService.get()
            .elements().getTextElement(By.cssSelector(".product-quantity strong"), "Quantity value");

    private final Button continueShoppingBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("button[class='btn btn-secondary']"), "'Continue shopping' button");

    private final Button proceedToCheckoutBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("div.cart-content-btn a[class='btn btn-primary']"), "'Proceed to checkout' button");

    @AllArgsConstructor
    public enum ProductAttributes implements IEnumParser {
        QUANTITY("Quantity");

        @Getter
        private final String elementName;

        public static ProductAddedModalForm.ProductAttributes parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, BaseElement> elements = new HashMap<>()
    {
        {
            put(ProductAttributes.QUANTITY.elementName, quantityTxt);
        }
    };

    @Override
    public HashMap<String, BaseElement> getElementsMap() {
        return this.elements;
    }

    public ProductAddedModalForm() {
        super(By.cssSelector(".cart-content-btn .btn-secondary"), "'Proceed to checkout' button");
    }

    public void clickContinueShopping()
    {
        this.continueShoppingBtn.click();
    }

    public void clickProceedToCheckout()
    {
        this.proceedToCheckoutBtn.click();
    }
}
