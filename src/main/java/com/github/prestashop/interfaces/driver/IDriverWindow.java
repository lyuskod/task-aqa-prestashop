package com.github.prestashop.interfaces.driver;

import java.util.function.Consumer;
import java.util.function.Function;

public interface IDriverWindow {
    void setFullScreen();

    byte[] getScreenshot();

    void switchToFrame(String nameOrIdCss);

    void switchToDefaultContent();

    void doInFrame(String nameOrIdCss, Consumer<String> action);
}
