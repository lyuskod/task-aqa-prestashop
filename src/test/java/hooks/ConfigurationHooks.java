package hooks;

import services.driver.AutomationService;
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
