package com.github.prestashop.pages.forms;

import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class NavigationMenuForm extends PageProxy {
    private final MenuItem cartMenuItem = AutomationService.get()
            .elements().getMenuItem(By.cssSelector("#_desktop_cart .cart-products-count"), "'Cart' navigation menu item");

    private final MenuItem languageMenuItem = AutomationService.get()
            .elements().getMenuItem(By.cssSelector("#_desktop_language_selector"), "'Language' navigation menu item");

    private final MenuItem signInMenuItem = AutomationService.get()
            .elements().getMenuItem(By.cssSelector("#_desktop_user_info"), "'Sign in' navigation menu item");

    @AllArgsConstructor
    public enum NavigationMenuElements implements IEnumParser {
        LANGUAGE("Language"),
        CART("Cart"),
        SIGN_IN("Sign in");

        @Getter
        private final String elementName;

        public static NavigationMenuForm.NavigationMenuElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(NavigationMenuElements.CART.elementName, cartMenuItem);
            put(NavigationMenuElements.LANGUAGE.elementName, languageMenuItem);
            put(NavigationMenuElements.SIGN_IN.elementName, signInMenuItem);
        }
    };


    public NavigationMenuForm() {
        super(By.cssSelector("#_desktop_cart"), "Navigation bar");
    }

    public String getCurrentCartProductsCount() {
        return this.cartMenuItem.getTextValue();
    }

    public void clickNavigationMenuItem(NavigationMenuElements menuItem) {
        elements.get(menuItem.elementName).click();
    }
}
