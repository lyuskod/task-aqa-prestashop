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
        Personal_Information(new PersonalInformationPage()),
        Product_Added(new ProductAddedModalForm()),
        Addresses(new AddressesPage()),
        Shipping_Method(new ShippingMethodPage()),
        Payment(new PaymentPage()),
        Order_confirmed(new OrderConfirmedPage());

        @Getter
        private final BaseForm pageInstance;

        public static Pages parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }
}
