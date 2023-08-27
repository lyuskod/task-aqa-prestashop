package com.github.prestashop.hooks;

import com.github.prestashop.helpers.ConfigHelper;
import com.github.prestashop.services.driver.Automation;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class BrowserHooks {
    @Before
    public void openApp() {
        Automation.get().browser().go(ConfigHelper.get().getBaseUrl());
    }

    @After(order = 2)
    public void endSession() {
        Automation.get().endSession();
    }
}
