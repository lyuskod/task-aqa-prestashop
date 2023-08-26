package com.github.prestashop.steps;

import com.github.prestashop.cucumber.ElementsHelper;
import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.pages.pages.AddressesPage;
import io.cucumber.java.en.When;

import java.util.List;

public class AddressesSteps {

    private final AddressesPage addressesPage;

    public AddressesSteps()
    {
        addressesPage = new AddressesPage();
    }

    @When("I configure the Addresses page as follows:")
    public void configureAddressesPage(List<ElementDto> elements)
    {
        MainFrame.doInFrame(arg -> {
            ElementsHelper.configureElements(addressesPage, elements);
        });
        AllureHelper.takeAndAttachScreenShot();
    }

    @When("I click Continue on the Addresses page")
    public void clickContinueBtnOnAddressesPage()
    {
        MainFrame.doInFrame(arg -> this.addressesPage.clickContinueBtn());
    }
}
