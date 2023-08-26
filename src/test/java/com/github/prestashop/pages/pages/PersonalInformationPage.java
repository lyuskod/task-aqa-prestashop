package com.github.prestashop.pages.pages;

import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.pages.PageProxy;
import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PersonalInformationPage extends PageProxy implements IElementsHelper {

    private final TextBox firstNameTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-firstname"), "First name input");
    private final TextBox lastNameTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-lastname"), "Last name input");
    private final TextBox emailTxb = AutomationService.get()
            .elements().getTextBox(By.cssSelector("#field-email"), "Email input");

    private final ClickableCheckbox receiveOffersFromPartnersCheckbox = AutomationService.get()
            .elements().getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[1]"), "Receive offers from partners checkbox");

    private final ClickableCheckbox agreeTermsAndConditions = AutomationService.get()
            .elements().getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[2]"), "Agree terms and conditions");

    private final ClickableCheckbox customDataPrivacyCcb = AutomationService.get()
            .elements().getClickableCheckbox(By.xpath("(//*[@class='custom-checkbox']/label)[4]"), "Custom data privacy checkbox");

    private final Button continueBtn = AutomationService.get()
            .elements().getButton(By.cssSelector("footer[class='form-footer clearfix'] button[name='continue']"), "Continue");

    private final ClickableRadioButton selectTypeMrRb = AutomationService.get()
            .elements().getClickableRadioButton(By.cssSelector("[for='field-id_gender-1']"), "Select type 'Mr'");
    private final HashMap<String, BaseElement> elements = new HashMap<>() {
        {
            put(PersonalInfoElements.First_name.elementName, firstNameTxb);
            put(PersonalInfoElements.Last_name.elementName, lastNameTxb);
            put(PersonalInfoElements.Email.elementName, emailTxb);
            put(PersonalInfoElements.Receive_Offers_From_Others.elementName, receiveOffersFromPartnersCheckbox);
            put(PersonalInfoElements.Agree_Terms_And_Conditions.elementName, agreeTermsAndConditions);
            put(PersonalInfoElements.Customer_Data_Privacy.elementName, customDataPrivacyCcb);
            put(PersonalInfoElements.Continue.elementName, continueBtn);
            put(PersonalInfoElements.Social_title_Mr.elementName, selectTypeMrRb);
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

    public void clickContinueBtn()
    {
        this.continueBtn.click();
    }
}
