package pages.forms;

import interfaces.element.IBaseElement;
import interfaces.enums.IEnumParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import services.element.Button;
import services.element.TextBox;
import services.page.BaseForm;

import java.util.HashMap;

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
