package com.github.prestashop.pages.forms;

import com.github.prestashop.services.driver.Automation;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.TextBox;
import com.github.prestashop.services.page.BaseForm;

public class ProductOverviewForm extends BaseForm {
    private final Button addToCartButton = Automation.get()
            .elements()
            .getButton(By.cssSelector("[data-button-action='add-to-cart']"), "\"Add to cart\" button");

    private final TextBox quantityTextBox = Automation.get()
            .elements()
            .getTextBox(By.cssSelector("#quantity_wanted"), "\"Quantity\" input");

    public ProductOverviewForm() {
        super(By.xpath("[data-button-action='add-to-cart']"), "Product overview");
    }

    public void enterQuantity(int count) {
        this.quantityTextBox.clearAndType(String.valueOf(count));
    }

    public void addToCart() {
        this.addToCartButton.jsClick();
    }
}
