package com.github.prestashop.steps.assertions;

import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.helpers.PageHelper;
import com.github.prestashop.services.driver.AutomationService;
import io.cucumber.java.en.Then;

public class CommonAssertions {
    @Then("I verify that '{pageNameTransform}' page/form/modal is '{isOpenedTransform}'")
    public void verifyPageStateStep(PageHelper.Pages page, boolean expectedState) {
        AutomationService.get().browser().window().switchToFrame("framelive");
        boolean actualState = page.getPageInstance().isOpened();
        String wordingState = BooleanExtensions.getWording(actualState);
        AssertHelper.assertEquals(actualState, expectedState,
                String.format("The '%s' page is %sopened", page.getDisplayedName(), wordingState), true);
    }
}
