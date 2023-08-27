package com.github.prestashop.interfaces.driver;

import com.github.prestashop.helpers.models.ScreenResolution;

public interface IBaseConfig {
    String getBrowserName();

    String getBaseUrl();

    String getVersion();

    boolean getElementHighlightEnabled();

    int getTimeoutImplicitSec();

    int getTimeoutScriptSec();

    int getTimeoutPageLoadSec();

    boolean getLoggerEnabled();

    ScreenResolution getScreenResolution();

    int executionSpeedDelaySec();
}
