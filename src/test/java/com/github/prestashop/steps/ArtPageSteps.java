package com.github.prestashop.steps;

import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AssertHelper;
import io.cucumber.java.en.Then;
import com.github.prestashop.pages.pages.ArtPage;

public class ArtPageSteps {

    private final ArtPage artPage;

    public ArtPageSteps()
    {
        this.artPage = new ArtPage();
    }

    @Then("I verify that Art page is '{isOpenedTransform}'")
    public void verifyArtPageOpenedStep(boolean expectedState)
    {
        boolean actualState = this.artPage.isOpened();
        AssertHelper.assertEquals(actualState, expectedState,
                String.format("The '%s' page is %sopened", this.artPage.getFormName(),
                        BooleanExtensions.getWording(actualState)), true);
    }
}
