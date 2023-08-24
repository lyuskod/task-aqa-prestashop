package com.github.prestashop.interfaces.driver;

public interface IDriverWindow {
    void setFullScreen();

    byte[] getScreenshot();

    void switchToFrame(String nameOrIdCss);

    void switchToDefaultContent();
}
