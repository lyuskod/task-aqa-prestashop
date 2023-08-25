package com.github.prestashop.pages.frames;

import com.github.prestashop.services.driver.AutomationService;
import com.github.prestashop.services.element.BaseElement;
import org.openqa.selenium.By;

import java.util.function.Consumer;

public class MainFrame extends BaseElement {

    public MainFrame() {
        super(By.cssSelector("#framelive"), "Main frame");
    }

    public static void doInFrame(Consumer action) {
        AutomationService.get().browser().window().doInFrame("framelive", action);
    }
}
