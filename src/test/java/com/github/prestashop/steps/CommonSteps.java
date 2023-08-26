package com.github.prestashop.steps;

import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.helpers.ConditionWaiters;
import com.github.prestashop.helpers.PageHelper;
import com.github.prestashop.pages.frames.MainFrame;
import io.cucumber.java.en.Then;

import java.time.Duration;

public class CommonSteps {
    @Then("I verify that '{pageNameTransform}' page/form/modal is '{isOpenedTransform}'")
    public void verifyPageStateStep(PageHelper.Pages page, boolean expectedState) {
        MainFrame.doInFrame((arg) -> {
            if (expectedState) {
                ConditionWaiters.waitUntilVisible(page.getPageInstance().getLocator(), Duration.ofSeconds(10));
            }
            boolean actualState = page.getPageInstance().isOpened();
            String wordingState = BooleanExtensions.getWording(actualState);
            AssertHelper.assertEquals(actualState, expectedState,
                    String.format("The '%s' page is %sopened", page.getDisplayedName(), wordingState), true);
        });
    }
}
