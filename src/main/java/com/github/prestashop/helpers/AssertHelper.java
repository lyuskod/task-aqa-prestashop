package com.github.prestashop.helpers;

import org.junit.jupiter.api.Assertions;

public class AssertHelper {

    private AssertHelper() {
    }

    public static void assertEquals(boolean actual, boolean expected, String message, boolean takeScreenshot) {
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
    }

    public static void assertEquals(String actual, String expected, String message, boolean takeScreenshot) {
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
    }

    public static void assertEquals(int actual, int expected, String message, boolean takeScreenshot) {
        AssertHelper.takeScreenshotIfTrue(takeScreenshot);
        Assertions.assertEquals(expected, actual, message);
    }

    private static void takeScreenshotIfTrue(boolean take) {
        if (take) {
            AllureHelper.takeAndAttachScreenShot();
        }
    }
}
