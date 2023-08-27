package com.github.prestashop.pages.forms;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.MenuItem;
import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.interfaces.enums.IEnumParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import com.github.prestashop.services.page.BaseForm;

import java.util.HashMap;

public class TopMenuForm extends BaseForm {
    private final MenuItem clothesMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#top-menu > #category-3"), "\"Clothes\" menu item");
    private final MenuItem accessoriesMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#top-menu > #category-6"), "\"Accessories\" menu item");
    private final MenuItem artMenuItem = Automation.get()
            .elements()
            .getMenuItem(By.cssSelector("#top-menu > #category-9"), "\"Art\" menu item");

    @AllArgsConstructor
    public enum TopMenuElements implements IEnumParser {
        CLOTHES("Clothes"),
        ACCESSORIES("Accessories"),
        ART("Art");

        @Getter
        private final String elementName;

        public static TopMenuForm.TopMenuElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, IBaseElement> elements = new HashMap<>() {
        {
            put(TopMenuElements.CLOTHES.elementName, clothesMenuItem);
            put(TopMenuElements.ACCESSORIES.getElementName(), accessoriesMenuItem);
            put(TopMenuElements.ART.elementName, artMenuItem);
        }
    };

    public TopMenuForm() {
        super(By.cssSelector("#top-menu"), "Top Menu");
    }

    public void clickTopMenuElement(TopMenuElements menuItem) {
        elements.get(menuItem.elementName).click();
    }
}
