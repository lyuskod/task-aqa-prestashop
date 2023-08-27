package com.github.prestashop.steps;

import com.github.prestashop.pages.forms.TopMenu;
import com.github.prestashop.pages.frames.MainFrame;
import io.cucumber.java.en.When;

public class NavigationSteps {

    private final TopMenu topMenu;

    public NavigationSteps() {
        this.topMenu = new TopMenu();
    }

    @When("I click on '(Clothes|Accessories|Art)' top menu item$")
    public void selectTopMenuItemStep(String topMenuItem) {
        MainFrame.doInFrame((arg) -> {
            var element = TopMenu.TopMenuElements.parse(topMenuItem);
            this.topMenu.clickTopMenuElement(element);
        });
    }
}
