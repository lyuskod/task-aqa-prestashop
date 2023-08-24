package steps;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AssertHelper;
import io.cucumber.java.en.Then;
import pages.pages.MainPage;

public class MainPageSteps {

    private final MainPage mainPage;

    public MainPageSteps() {
        this.mainPage = new MainPage();
    }

    @Then("I verify that Main Page is opened")
    public void verifyMainPageStateStep() {
        AutomationService.get().browser().getOriginalDriver().switchTo().frame("framelive");
        boolean actualState = this.mainPage.isOpened();
        AssertHelper.assertEquals(actualState, true,
                String.format("The '%s' page is %sopened", this.mainPage.getFormName(),
                        BooleanExtensions.getWording(actualState)), true);
    }
}
