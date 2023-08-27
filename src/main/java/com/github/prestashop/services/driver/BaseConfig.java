package com.github.prestashop.services.driver;

import com.github.prestashop.helpers.ConfigHelper;
import com.github.prestashop.helpers.models.ScreenResolution;
import com.github.prestashop.interfaces.driver.IBaseConfig;

public class BaseConfig implements IBaseConfig {
    @Override
    public String getBrowserName() {
        return ConfigHelper.get().getBrowserName();
    }

    @Override
    public String getBaseUrl() {
        return ConfigHelper.get().getBaseUrl();
    }

    @Override
    public String getVersion() {
        return ConfigHelper.get().getVersion();
    }

    @Override
    public String[] getOptions() {
        return ConfigHelper.get().getOptions();
    }

    @Override
    public boolean getElementHighlightEnabled() {
        return ConfigHelper.get().isElementHighlightEnabled();
    }

    @Override
    public int getTimeoutImplicitSec() {
        return ConfigHelper.get().getTimeouts().getTimeoutImplicitSec();
    }

    @Override
    public int getTimeoutScriptSec() {
        return ConfigHelper.get().getTimeouts().getTimeoutScriptSec();
    }

    @Override
    public int getTimeoutPageLoadSec() {
        return ConfigHelper.get().getTimeouts().getTimeoutPageLoadSec();
    }

    @Override
    public boolean getLoggerEnabled() {
        return ConfigHelper.get().getLogger().isEnabled();
    }

    @Override
    public ScreenResolution getScreenResolution() {
        return ConfigHelper.get().getScreenResolution();
    }

    @Override
    public int executionSpeedDelaySec() {
        return ConfigHelper.get().getExecutionSpeedDelaySec();
    }
}
