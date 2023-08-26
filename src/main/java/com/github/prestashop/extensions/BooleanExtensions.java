package com.github.prestashop.extensions;

import com.github.prestashop.services.logger.BaseLogger;

public class BooleanExtensions {
    private static final BaseLogger logger = BaseLogger.getLogger(BooleanExtensions.class);

    private BooleanExtensions() {
    }

    public static String getWording(boolean value) {
        logger.debug(String.format("[READY]: Get wording for '%s' boolean value", value));
        var wording = value ? "" : "not ";
        logger.debug(String.format("[SUCCESS]: Get wording for '%s' boolean value. Wording: '%s'", value, wording));
        return wording;
    }
}
