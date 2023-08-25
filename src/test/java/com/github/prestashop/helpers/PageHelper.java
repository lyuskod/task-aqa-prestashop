package com.github.prestashop.helpers;

import com.github.prestashop.interfaces.enums.IEnumParser;
import com.github.prestashop.pages.forms.ProductAddedModalForm;
import com.github.prestashop.pages.pages.*;
import com.github.prestashop.services.page.BaseForm;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class PageHelper {
    private PageHelper() {
    }

    @AllArgsConstructor
    public enum Pages implements IEnumParser {
        Main(new MainPage()),
        Art(new ArtPage()),
        Accessories(new AccessoriesPage()),
        Clothes(new ClothesPage()),
        Shopping_Cart(new ShoppingCartPage()),
        Product_Added(new ProductAddedModalForm());

        @Getter
        private final BaseForm pageInstance;

        public static Pages parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }
}
