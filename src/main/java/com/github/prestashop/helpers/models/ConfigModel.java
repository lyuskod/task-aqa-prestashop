package com.github.prestashop.helpers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigModel {
    private String browserName;

    private String version;

    private String baseUrl;

    private boolean elementHighlightEnabled;

    private TimeoutsConfigModel timeouts;

    private LoggerConfigModel logger;

    private ScreenResolution screenResolution;

    private int executionSpeedDelaySec;
}
