package com.github.prestashop.steps;

import com.github.prestashop.pages.forms.TopMenuForm;
import com.github.prestashop.pages.frames.MainFrame;
import io.cucumber.java.en.When;

public class NavigationSteps {

    private final TopMenuForm topMenuForm;

    public NavigationSteps() {
        this.topMenuForm = new TopMenuForm();
    }

    @When("I click on '(Clothes|Accessories|Art)' top menu item$")
    public void selectTopMenuItemStep(String topMenuItem) {
        MainFrame.doInFrame((arg) -> {
            var element = TopMenuForm.TopMenuElements.parse(topMenuItem);
            this.topMenuForm.clickTopMenuElement(element);
        });
    }
}
