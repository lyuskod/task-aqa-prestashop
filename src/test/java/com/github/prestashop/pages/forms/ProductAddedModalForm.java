package com.github.prestashop.pages.forms;

import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.element.BaseElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Text;
import com.github.prestashop.services.page.BaseForm;

import java.util.HashMap;

public class ProductAddedModalForm extends PageProxy implements IElementsHelper {

    private final Text quantityTxt = new Text(By.cssSelector(".product-quantity strong"), "Quantity value");

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

    public String getAttributeValue(String attribute)
    {
        return ((Text) elements.get(attribute)).getTextValue();
    }
}
