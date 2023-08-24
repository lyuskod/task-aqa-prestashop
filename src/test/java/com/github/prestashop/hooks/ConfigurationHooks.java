package com.github.prestashop.hooks;

import com.github.prestashop.helpers.AllureHelper;
import com.github.prestashop.services.driver.AutomationService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ConfigurationHooks {

    @Before
    public void configure()
    {
        AutomationService.get().browser().window().setFullScreen();
        AutomationService.get().browser().timeouts().setDefaultTimeouts();
//        AutomationService.get().browser().window().switchToFrame("framelive");
    }

    @After
    public void endSession()
    {
        AutomationService.get().browser().session().end();
    }
}
