package com.github.prestashop.extensions;

public class BooleanExtensions {
    private BooleanExtensions() {
    }

    public static String getWording(boolean value) {
        return value ? "" : "not ";
    }
}
