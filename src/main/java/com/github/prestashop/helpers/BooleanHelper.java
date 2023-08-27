package com.github.prestashop.helpers;

import com.github.prestashop.services.logger.BaseLogger;

public class BooleanHelper {
    private static final BaseLogger logger = BaseLogger.getLogger(BooleanHelper.class);

    private BooleanHelper() {
    }

    public static String getWording(boolean value) {
        logger.debug(String.format("[READY]: Get wording for '%s' boolean value", value));
        var wording = value ? "" : "not ";
        logger.debug(String.format("[SUCCESS]: Get wording for '%s' boolean value. Wording: '%s'", value, wording));
        return wording;
    }
}
