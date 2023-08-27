package com.github.prestashop.interfaces.driver;

import java.util.function.Consumer;

public interface IDriverWindow {
    void setFullScreen();

    void setMaximize();

    void setSize(int width, int height);

    byte[] getScreenshot();

    void switchToFrame(String nameOrIdCss);

    void switchToDefaultContent();

    void doInFrame(String nameOrIdCss, Consumer<String> action);
}
