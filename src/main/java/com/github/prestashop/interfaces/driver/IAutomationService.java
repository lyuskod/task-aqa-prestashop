package com.github.prestashop.interfaces.driver;

import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.services.driver.ElementsCollection;

public interface IAutomationService {
    BaseDriver browser();

    ElementsCollection elements();
}
