package steps;

import io.cucumber.java.en.When;
import pages.pages.MainPage;
import pages.forms.TopMenu;
import com.github.prestashop.services.driver.AutomationService;
import io.cucumber.java.en.Given;

public class NavigationSteps {

    private final MainPage mainPage;

    public NavigationSteps()
    {
        this.mainPage = new MainPage();
    }

    @Given("I open app")
    public void openAppStep() throws Exception {
        AutomationService.get()
                .browser().go("https://demo.prestashop.com/#/en/front");
    }

    @When("^I click '(Clothes|Accessories|Art)' top menu item$")
    public void selectTopMenuItemStep(String topMenuItem)
    {
        var element = TopMenu.TopMenuElements.parse(topMenuItem);
        this.mainPage.topMenu().clickTopMenuElement(element);
    }
}
