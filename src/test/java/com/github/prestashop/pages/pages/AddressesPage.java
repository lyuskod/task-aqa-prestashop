package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.DropDown;
import com.github.prestashop.services.element.TextBox;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class AddressesPage extends BaseForm implements IElementsHelper {

    private final TextBox addressTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-address1"), "Address");

    private final TextBox postalCodeTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-postcode"), "Postal Code");

    private final TextBox cityTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-city"), "City");

    private final DropDown country = AutomationService.get()
            .elements().getDropDown(By.cssSelector("#field-id_country"), "Country");

    private final Button continueBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("button[name='confirm-addresses']"), "Continue");

    private final DropDown stateDropDown = AutomationService.get()
            .elements().getDropDown(By.cssSelector("#field-id_state"), "State");

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(AddressesPageElements.Addresses.elementName, addressTxb);
            put(AddressesPageElements.Postal_Code.elementName, postalCodeTxb);
            put(AddressesPageElements.City.elementName, cityTxb);
            put(AddressesPageElements.Country.elementName, country);
            put(AddressesPageElements.State.elementName, stateDropDown);
        }
    };

    @AllArgsConstructor
    public enum AddressesPageElements implements IEnumParser {
        Addresses("Addresses"),
        Postal_Code("Postal Code"),
        City("City"),
        Country("Country"),
        State("State");

        @Getter
        private final String elementName;

        public static AddressesPage.AddressesPageElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    public AddressesPage() {
        super(By.cssSelector("#checkout-addresses-step"), "Addresses");
    }

    @Override
    public HashMap<String, BaseElement> getElementsMap() {
        return elements;
    }

    public void clickContinueBtn() {
        this.continueBtn.click();
    }
}
