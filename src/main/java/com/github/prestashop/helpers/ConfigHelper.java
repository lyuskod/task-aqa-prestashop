package com.github.prestashop.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.prestashop.helpers.models.ConfigModel;

import java.io.IOException;

public class ConfigHelper {
    private static ConfigModel config;

    public static ConfigModel get() {
        if (config == null) {
            try {
                final var configPath = "/settings.json";
                var inputStream = ConfigHelper.class.getResourceAsStream(configPath);
                config = new ObjectMapper().readValue(inputStream, ConfigModel.class);
            } catch (IOException e) {
                throw new RuntimeException(String.format("Cannot load automation service config by path resources/settings.json. Exception thrown: %s", e.getMessage()));
            }
        }
        return config;
    }
}
