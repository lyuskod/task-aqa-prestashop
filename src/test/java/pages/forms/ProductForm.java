package pages.forms;

import org.openqa.selenium.By;
import com.github.prestashop.services.element.Button;
import com.github.prestashop.services.element.TextBox;
import com.github.prestashop.services.page.BaseForm;

public class ProductForm extends BaseForm {

    private final Button addToCartBtn = new Button(By.cssSelector("[data-button-action='add-to-cart']"), "'Add to cart' button");
    private final TextBox quantityTbx = new TextBox(By.cssSelector("#quantity_wanted"), "'Quantity' input");

    public ProductForm() {
        super(By.xpath("[data-button-action='add-to-cart']"), "'Add to cart' button");
    }

    public void enterQuantity(int count)
    {
        this.quantityTbx.clearAndType(String.valueOf(count));
    }

    public void clickAddToCartBtn()
    {
        this.addToCartBtn.click();
    }
}
