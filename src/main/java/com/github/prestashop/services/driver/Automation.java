package com.github.prestashop.services.driver;

import com.github.prestashop.factory.BrowserFactory;
import com.github.prestashop.helpers.BrowserHelper;
import com.github.prestashop.helpers.ConfigHelper;
import com.github.prestashop.interfaces.driver.IAutomation;
import com.github.prestashop.services.logger.BaseLogger;

public class Automation implements IAutomation {
    private static final BaseLogger logger = BaseLogger.getLogger(Automation.class);
    private final BaseDriver driver;

    private final ElementCreator elementsCollection;

    private final BaseConfig config;

    private static Automation instance;

    private Automation() {
        this.driver = BrowserFactory.getDriver(ConfigHelper.get().getBrowserName());
        BrowserHelper.configureBrowser(this.driver);
        this.elementsCollection = new ElementCreator(this.driver);
        this.config = new BaseConfig();
    }

    public static Automation get() {
        if (Automation.instance == null) {
            Automation.instance = new Automation();
        }
        return Automation.instance;
    }

    @Override
    public BaseDriver browser() {
        return this.driver;
    }

    @Override
    public ElementCreator elements() {
        return this.elementsCollection;
    }

    @Override
    public BaseConfig config() {
        return this.config;
    }

    @Override
    public void endSession() {
        logger.info("[READY]: End driver session");
        Automation.instance.browser().getOriginalDriver().quit();
        Automation.instance = null;
        logger.info("[SUCCESS]: End driver session");
    }
}
