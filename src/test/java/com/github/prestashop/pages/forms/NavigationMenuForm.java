package com.github.prestashop.pages.forms;

import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.MenuItem;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class NavigationMenuForm extends BaseForm {
    private final MenuItem cartMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#_desktop_cart .cart-products-count"), "\"Cart\" navigation menu item");

    private final MenuItem languageMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#_desktop_language_selector"), "\"Language\" navigation menu item");

    private final MenuItem signInMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#_desktop_user_info"), "\"Sign in\" navigation menu item");

    @AllArgsConstructor
    public enum ProductCategories implements IEnumParser {
        LANGUAGE("Language"),
        CART("Cart"),
        SIGN_IN("Sign in");

        @Getter
        private final String elementName;

        public static ProductCategories parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(ProductCategories.CART.elementName, cartMenuItem);
            put(ProductCategories.LANGUAGE.elementName, languageMenuItem);
            put(ProductCategories.SIGN_IN.elementName, signInMenuItem);
        }
    };

    public NavigationMenuForm() {
        super(By.cssSelector("#_desktop_cart"), "Navigation menu form");
    }

    public String getCartProductsCount() {
        return this.cartMenuItem.getTextValue();
    }

    public void openProductCategory(ProductCategories category) {
        elements.get(category.elementName).click();
    }
}
