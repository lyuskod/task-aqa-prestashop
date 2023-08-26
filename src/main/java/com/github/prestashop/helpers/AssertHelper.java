package com.github.prestashop.helpers;

import com.github.prestashop.services.logger.BaseLogger;
import org.junit.jupiter.api.Assertions;

public class AssertHelper {
    private static final BaseLogger logger = BaseLogger.getLogger(AssertHelper.class);

    private AssertHelper() {
    }

    public static void assertEquals(boolean actual, boolean expected, String message, boolean takeScreenshot) {
        logger.info(String.format("[READY]: Assert two booleans. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
        logger.info(String.format("[SUCCESS]: Assert two booleans. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
    }

    public static void assertEquals(String actual, String expected, String message, boolean takeScreenshot) {
        logger.info(String.format("[READY]: Assert two strings. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
        logger.info(String.format("[SUCCESS]: Assert two strings. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
    }

    public static void assertEquals(int actual, int expected, String message, boolean takeScreenshot) {
        logger.info(String.format("[READY]: Assert two integers. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
        logger.info(String.format("[SUCCESS]: Assert two integers. Actual: %s, Expected: %s. Take screenshot: %s. Message: %s", actual, expected, takeScreenshot, message));
    }

    private static void takeScreenshotIfTrue(boolean take) {
        if (take) {
            AllureHelper.takeAndAttachScreenShot();
        }
    }
}
