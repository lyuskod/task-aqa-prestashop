package com.github.prestashop.pages.forms;

import com.github.prestashop.pages.PageProxy;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Label;
import com.github.prestashop.services.page.BaseForm;

public class ProductsForm extends PageProxy {

    private final ProductForm productForm;
    public ProductsForm() {
        super(By.xpath("//div[@id='js-product-list']/div[contains(@class,'products row')]"), "Products thumbnail");
        this.productForm = new ProductForm();
    }

    public ProductForm selectProductByIndex(int index)
    {
        var productLocator = String.format("(//article[@data-id-product])[%d]", index);
        new Label(By.xpath(productLocator), "Product with index = " + index).click();
        return this.productForm;
    }
}
