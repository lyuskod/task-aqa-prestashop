package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.cucumber.IElementsMap;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.BaseElement;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.DropDown;
import com.github.prestashop.services.element.TextBox;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class AddressesPage extends BaseForm implements IElementsMap {
    private final TextBox addressTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-address1"), "\"Address\" input");

    private final TextBox postalCodeTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-postcode"), "\"Postal Code\" input");

    private final TextBox cityTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-city"), "\"City\" input");

    private final DropDown countryDropDown = Automation.get()
            .elements()
            .getDropDown(By.cssSelector("#field-id_country"), "\"Country\" dropdown");

    private final DropDown stateDropDown = Automation.get()
            .elements()
            .getDropDown(By.cssSelector("#field-id_state"), "\"State\" dropdown");

    private final Button continueButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("button[name='confirm-addresses']"), "\"Continue\" button");

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

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(AddressesPageElements.Addresses.elementName, addressTextBox);
            put(AddressesPageElements.Postal_Code.elementName, postalCodeTextBox);
            put(AddressesPageElements.City.elementName, cityTextBox);
            put(AddressesPageElements.Country.elementName, countryDropDown);
            put(AddressesPageElements.State.elementName, stateDropDown);
        }
    };

    public AddressesPage() {
        super(By.cssSelector("#checkout-addresses-step"), "Addresses");
    }

    @Override
    public HashMap<String, BaseElement> getElementsMap() {
        return elements;
    }

    public void clickContinueBtn() {
        this.continueButton.click();
    }
}
