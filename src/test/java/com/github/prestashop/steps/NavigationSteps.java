package com.github.prestashop.steps;

import com.github.prestashop.pages.forms.TopMenu;
import com.github.prestashop.pages.frames.MainFrame;
import com.github.prestashop.services.driver.Automation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NavigationSteps {

    private final TopMenu topMenu;

    public NavigationSteps() {
        this.topMenu = new TopMenu();
    }

    @Given("I open app")
    public void openAppStep() {
        Automation.get()
                .browser()
                .go("https://demo.prestashop.com/#/en/front");
    }

    @When("I click on '(Clothes|Accessories|Art)' top menu item$")
    public void selectTopMenuItemStep(String topMenuItem) {
        MainFrame.doInFrame((arg) -> {
            var element = TopMenu.TopMenuElements.parse(topMenuItem);
            this.topMenu.clickTopMenuElement(element);
        });
    }
}
