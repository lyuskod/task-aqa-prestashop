package steps;

import com.github.prestashop.extensions.BooleanExtensions;
import com.github.prestashop.helpers.AssertHelper;
import io.cucumber.java.en.Then;
import pages.pages.ArtPage;

public class ArtPageSteps {

    private final ArtPage artPage;

    public ArtPageSteps()
    {
        this.artPage = new ArtPage();
    }

    @Then("^I verify that Art page is opened")
    public void verifyArtPageOpenedStep()
    {
        boolean actualState = this.artPage.isOpened();
        AssertHelper.assertEquals(actualState, true,
                String.format("The '%s' page is %sopened", this.artPage.getFormName(),
                        BooleanExtensions.getWording(actualState)), true);
    }
}
