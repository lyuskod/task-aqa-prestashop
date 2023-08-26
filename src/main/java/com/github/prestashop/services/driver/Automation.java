package com.github.prestashop.services.driver;

import com.github.prestashop.factory.BrowserFactory;
import com.github.prestashop.interfaces.driver.IAutomation;

public class Automation implements IAutomation {
    private final BaseDriver driver;

    private final ElementCreator elementsCollection;

    private static Automation instance;

    private Automation() {
        this.driver = BrowserFactory.getDriver(BrowserFactory.BrowserTypes.FIREFOX);
        this.elementsCollection = new ElementCreator(this.driver);
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
}
