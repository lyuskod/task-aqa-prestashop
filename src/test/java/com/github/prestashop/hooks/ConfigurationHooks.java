package com.github.prestashop.hooks;

import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.services.driver.AutomationService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;

public class ConfigurationHooks {

    @Before
    public void configure() {
        AutomationService.get().browser().window().setFullScreen();
        AutomationService.get().browser().timeouts().setDefaultTimeouts();
    }

    @After(order = 1)
    public void takeScreenShootOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(AutomationService.get().browser().window().getScreenshot(),
                    AllureHelper.AttachmentFormats.Image_PNG.getFormat(), String.format("Screenshot_%s_%s", scenario.getName(),
                            new SimpleDateFormat()));
        }
    }

    @After(order = 2)
    public void endSession() {
        AutomationService.get().browser().session().end();
    }
}
