package com.github.prestashop.extensions;

import com.github.prestashop.services.logger.BaseLogger;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;
import java.util.regex.Pattern;

public class StringExtensions {
    private static final BaseLogger logger = BaseLogger.getLogger(StringExtensions.class);
    private static final int LENGTH = 10;
    private static final boolean USE_LETTERS = true;
    private static final boolean USE_NUMBERS = true;

    public enum StringCaseFormat {
        LOWER_CASE,
        UPPER_CASE
    }

    private StringExtensions() {
    }

    public static String generateRandomString(int length, boolean useLetters, boolean useNumbers, StringCaseFormat format) {
        logger.debug(String
                .format("[READY]: Generate random string with '%s' length. Use letters: '%s'. Use numbers: '%s'. Case format: '%s'",
                        length, useLetters, useNumbers, format));
        var randomString = RandomStringUtils.random(length, useLetters, useNumbers);
        switch (format) {
            case LOWER_CASE -> randomString.toLowerCase(Locale.ROOT);
            case UPPER_CASE -> randomString.toUpperCase(Locale.ROOT);
            default -> throw new IllegalArgumentException(String.format("Value '%s' is not defined", format));
        }
        logger.debug(String
                .format("[SUCCESS]: Generate random string with '%s' length. Use letters: '%s'. Use numbers: '%s'. Case format: '%s'. Generated string: '%s'",
                        length, useLetters, useNumbers, format, randomString));
        return randomString;
    }

    public static String generateRandomString() {
        return generateRandomString(LENGTH, USE_LETTERS, USE_NUMBERS, StringCaseFormat.LOWER_CASE);
    }

    public static int extractNumberFromString(String str) {
        logger.debug(String.format("[READY]: Extract number from '%s' string", str));
        String output = null;
        var pattern = Pattern.compile(".*(\\d+).*");
        var matcher = pattern.matcher(str);
        if (matcher.matches()) {
            output = matcher.group(1);
        }
        var intValue = Integer.parseInt(output);
        logger.debug(String.format("[READY]: Extract number from '%s' string. Extracted value: '%d'", str, intValue));
        return intValue;
    }
}
