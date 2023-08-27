package com.github.prestashop.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrowserTypes {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String value;

    public String getValue() {
        return value;
    }
}
