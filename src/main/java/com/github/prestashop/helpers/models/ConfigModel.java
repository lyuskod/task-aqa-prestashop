package com.github.prestashop.helpers.models;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@Getter
@Setter
public class ConfigModel {
    private String browserName;

    private String version;

    private String baseUrl;

    private String[] options;

    private boolean elementHighlightEnabled;

    private TimeoutsConfigModel timeouts;

    private LoggerConfigModel logger;

    private ScreenResolution screenResolution;

    private int executionSpeedDelaySec;
}
