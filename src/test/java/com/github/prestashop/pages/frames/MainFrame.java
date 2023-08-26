package com.github.prestashop.pages.frames;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.element.BaseElement;
import org.openqa.selenium.By;

import java.util.function.Consumer;

public class MainFrame extends BaseElement {

    public MainFrame() {
        super(By.cssSelector("#framelive"), "Main frame");
    }

    public static void doInFrame(Consumer action) {
        Automation.get().browser().window().doInFrame("framelive", action);
    }
}
