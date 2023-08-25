package com.github.prestashop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ProductModelDto {
    @Getter @Setter
    private int Quantity;

    @Getter @Setter
    private int Position;
}
