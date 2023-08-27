package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.cucumber.IElementsMap;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.*;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PersonalInformationPage extends BaseForm implements IElementsMap {
    private final TextBox firstNameTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-firstname"), "\"First name\" input");
    private final TextBox lastNameTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-lastname"), "\"Last name\" input");
    private final TextBox emailTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#field-email"), "\"Email\" input");

    private final ClickableCheckBox receiveOffersFromPartnersClickableCheckBox = Automation.get()
            .elements()
            .getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[1]"), "\"Receive offers from partners checkbox\" checkbox");

    private final ClickableCheckBox agreeTermsAndConditionsClickableCheckBox = Automation.get()
            .elements()
            .getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[2]"), "\"Agree terms and conditions\" checkbox");

    private final ClickableCheckBox customDataPrivacyClickableCheckBox = Automation.get()
            .elements()
            .getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[4]"), "\"Custom data privacy checkbox\" checkbox");

    private final Button continueButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("footer[class='form-footer clearfix'] button[name='continue']"), "\"Continue\" button");

    private final ClickableRadioButton selectTypeMrClickableRadioButton = Automation.get()
            .elements()
            .getClickableRadioButton(By.cssSelector("[for='field-id_gender-1']"), "\"Select type 'Mr'\" radio button");

    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(PersonalInfoElements.First_name.elementName, firstNameTextBox);
            put(PersonalInfoElements.Last_name.elementName, lastNameTextBox);
            put(PersonalInfoElements.Email.elementName, emailTextBox);
            put(PersonalInfoElements.Receive_Offers_From_Others.elementName, receiveOffersFromPartnersClickableCheckBox);
            put(PersonalInfoElements.Agree_Terms_And_Conditions.elementName, agreeTermsAndConditionsClickableCheckBox);
            put(PersonalInfoElements.Customer_Data_Privacy.elementName, customDataPrivacyClickableCheckBox);
            put(PersonalInfoElements.Continue.elementName, continueButton);
            put(PersonalInfoElements.Social_title_Mr.elementName, selectTypeMrClickableRadioButton);
        }
    };

    @AllArgsConstructor
    public enum PersonalInfoElements implements IEnumParser {
        Social_title_Mr("Social title Mr"),
        First_name("First name"),
        Last_name("Last name"),
        Email("Email"),
        Receive_Offers_From_Others("Receive Offers From Others"),
        Agree_Terms_And_Conditions("Agree Terms And Conditions"),
        Customer_Data_Privacy("Customer Data Privacy"),
        Continue("Continue");

        @Getter
        private final String elementName;

        public static PersonalInformationPage.PersonalInfoElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    public PersonalInformationPage() {
        super(By.cssSelector("#checkout-personal-information-step"), "Order details");
    }

    @Override
    public HashMap<String, BaseElement> getElementsMap() {
        return this.elements;
    }

    public void clickContinueBtn() {
        this.continueButton.jsClick();
    }
}
