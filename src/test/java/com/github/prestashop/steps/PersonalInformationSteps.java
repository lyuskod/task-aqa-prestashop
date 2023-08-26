package com.github.prestashop.steps;

import com.github.prestashop.cucumber.ElementsHelper;
import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.PersonalInformationPage;
import io.cucumber.java.en.When;

import java.util.List;

public class PersonalInformationSteps {

    private final PersonalInformationPage personalInformationPage;

    public PersonalInformationSteps() {
        this.personalInformationPage = new PersonalInformationPage();
    }

    @When("I configure the Personal Information page as follows:")
    public void configurePersonalInformation(List<ElementDto> elements) {
        MainFrame.doInFrame(arg -> {
            ElementsHelper.configureElements(personalInformationPage, elements);
        });
        AllureHelper.takeAndAttachScreenShot();
    }

    @When("I click Continue button on Personal Information page")
    public void clickContinueBtnOnPersonalInformation() {
        MainFrame.doInFrame(arg -> personalInformationPage.clickContinueBtn());
    }
}
