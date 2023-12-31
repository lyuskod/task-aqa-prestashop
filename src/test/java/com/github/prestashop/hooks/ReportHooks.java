package com.github.prestashop.hooks;

import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.services.driver.Automation;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;

public class ReportHooks {
    @After(order = 1)
    public void takeScreenShootOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(Automation.get().browser().window().getScreenshot(),
                    AllureHelper.AttachmentFormats.Image_PNG.getFormat(), String.format("Screenshot_%s_%s", scenario.getName(),
                            new SimpleDateFormat()));
        }
    }
}
