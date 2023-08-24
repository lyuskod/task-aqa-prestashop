package com.github.prestashop.services.driver;

import com.github.prestashop.factory.BrowserFactory;
import com.github.prestashop.interfaces.driver.IAutomationService;

public class AutomationService implements IAutomationService {
    private final BaseDriver driver;

    private final ElementsCollection elementsCollection;

    private static AutomationService instance;

    private AutomationService() {
        this.driver = BrowserFactory.getDriver(BrowserFactory.BrowserTypes.FIREFOX);
        this.elementsCollection = new ElementsCollection(this.driver);
    }

    public static AutomationService get() {
        if (AutomationService.instance == null) {
            AutomationService.instance = new AutomationService();
        }
        return AutomationService.instance;
    }

    @Override
    public BaseDriver browser() {
        return this.driver;
    }

    @Override
    public ElementsCollection elements() {
        return this.elementsCollection;
    }
}
