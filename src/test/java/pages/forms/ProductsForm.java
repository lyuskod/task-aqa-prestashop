package pages.forms;

import org.openqa.selenium.By;
import services.element.Label;
import services.page.BaseForm;

public class ProductsForm extends BaseForm {

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
