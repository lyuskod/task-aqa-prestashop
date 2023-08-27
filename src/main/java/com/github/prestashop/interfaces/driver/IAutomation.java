package com.github.prestashop.interfaces.driver;

import com.github.prestashop.services.driver.BaseConfig;
import com.github.prestashop.services.driver.BaseDriver;
import com.github.prestashop.services.driver.ElementCreator;

public interface IAutomation {
    BaseDriver browser();

    ElementCreator elements();

    BaseConfig config();

    void endSession();
}
