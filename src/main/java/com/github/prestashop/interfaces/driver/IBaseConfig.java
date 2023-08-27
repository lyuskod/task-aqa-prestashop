package com.github.prestashop.interfaces.driver;

public interface IBaseConfig {
    String getBrowserName();

    String getBaseUrl();

    boolean getElementHighlightEnabled();

    int getTimeoutImplicitSec();

    int getTimeoutScriptSec();

    int getTimeoutPageLoadSec();

    boolean getLoggerEnabled();

    String getScreenMode();
}
