package com.github.prestashop.interfaces.driver;

import com.github.prestashop.helpers.models.ScreenResolution;

public interface IBaseConfig {
    String getBrowserName();

    String getBaseUrl();

    boolean getRemoteEnabled();

    String getRemoteUrl();

    String getVersion();

    String[] getOptions();

    boolean getElementHighlightEnabled();

    int getTimeoutImplicitSec();

    int getTimeoutScriptSec();

    int getTimeoutPageLoadSec();

    boolean getLoggerEnabled();

    ScreenResolution getScreenResolution();

    int executionSpeedDelayMs();
}
