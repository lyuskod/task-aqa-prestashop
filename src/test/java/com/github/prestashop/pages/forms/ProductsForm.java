package com.github.prestashop.pages.forms;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.services.page.BaseForm;
import org.openqa.selenium.By;

public class ProductsForm extends BaseForm {
    private final String productLocatorXPathToFormat;

    public ProductsForm() {
        super(By.xpath("//div[@id='js-product-list']/div[contains(@class,'products row')]"), "Products thumbnail");
        this.productLocatorXPathToFormat = "(//article[@data-id-product])[%d]";
    }

    public void selectProductByIndex(int index) {
        var productLocator = String.format(this.productLocatorXPathToFormat, index);
        Automation.get()
                .elements()
                .getLabel(By.xpath(productLocator), "Product with index = " + index)
                .click();
    }
}
