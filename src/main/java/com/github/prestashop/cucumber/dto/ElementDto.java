package com.github.prestashop.cucumber.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ElementDto {
    @Getter
    @Setter
    private String elementName;
    @Getter
    @Setter
    private String elementValue;
}
