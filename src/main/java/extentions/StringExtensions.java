package extentions;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class StringExtensions {

    private static final int LENGTH = 10;
    private static final boolean USE_LETTERS = true;
    private static final boolean USE_NUMBERS = true;

    public enum StringCaseFormat {
        LOWER_CASE,
        UPPER_CASE
    }

    private StringExtensions(){}

    public static String generateRandomString(int length, boolean useLetters, boolean useNumbers, StringCaseFormat format){
        String randomString = RandomStringUtils.random(length, useLetters, useNumbers);
        switch (format){
            case LOWER_CASE:
                randomString.toLowerCase(Locale.ROOT);
                break;
            case UPPER_CASE:
                randomString.toUpperCase(Locale.ROOT);
                break;
            default: throw new IllegalArgumentException(String.format("Value '%s' is not defined", format));
        }
        return randomString;
    }

    public static String generateRandomString(){
        return generateRandomString(LENGTH, USE_LETTERS, USE_NUMBERS, StringCaseFormat.LOWER_CASE);
    }
}
