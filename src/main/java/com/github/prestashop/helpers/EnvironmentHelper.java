package com.github.prestashop.helpers;

public class EnvironmentHelper {
    private EnvironmentHelper() {
    }

    public static boolean isDocker() {
        var isDocker = System.getenv("IS_DOCKER");
        return isDocker != null && Boolean.getBoolean(isDocker);
    }
}
