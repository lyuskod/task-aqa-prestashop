package com.github.prestashop.interfaces.form;

import org.openqa.selenium.By;

public interface IBaseForm {
    By getLocator();

    String getFormName();

    boolean isOpened();
}
