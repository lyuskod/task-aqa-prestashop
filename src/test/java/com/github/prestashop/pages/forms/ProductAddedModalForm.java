package com.github.prestashop.pages.forms;

import com.github.prestashop.interfaces.cucumber.IElementsMap;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Text;

import java.util.HashMap;

public class ProductAddedModalForm extends BaseForm implements IElementsMap {
    private final Text quantityText = Automation.get()
            .elements()
            .getTextElement(By.cssSelector(".product-quantity strong"), "\"Quantity\" text");

    private final Button continueShoppingButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("button[class='btn btn-secondary']"), "\"Continue shopping\" button");

    private final Button proceedToCheckoutButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("div.cart-content-btn a[class='btn btn-primary']"), "\"Proceed to checkout\" button");

    @AllArgsConstructor
    public enum ProductAttributes implements IEnumParser {
        QUANTITY("Quantity");

        @Getter
        private final String elementName;

        public static ProductAddedModalForm.ProductAttributes parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(ProductAttributes.QUANTITY.elementName, quantityText);
        }
    };

    @Override
    public HashMap<String, BaseElement> getElementsMap() {
        return this.elements;
    }

    public ProductAddedModalForm() {
        super(By.cssSelector(".cart-content-btn .btn-secondary"), "Product added form");
    }

    public void continueShopping() {
        this.continueShoppingButton.click();
    }

    public void proceedToCheckout() {
        this.proceedToCheckoutButton.click();
    }
}
