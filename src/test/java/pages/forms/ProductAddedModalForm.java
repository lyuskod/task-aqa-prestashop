package pages.forms;

import com.github.prestashop.interfaces.element.IBaseElement;
import com.github.prestashop.interfaces.enums.IEnumParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import com.github.prestashop.services.element.Text;
import com.github.prestashop.services.page.BaseForm;

import java.util.HashMap;

public class ProductAddedModalForm extends BaseForm {

    private final Text quantityTxt = new Text(By.cssSelector(".product-quantity strong"), "Quantity value");

    @AllArgsConstructor
    public enum ProductAttributes implements IEnumParser {
        QUANTITY("Quantity");

        @Getter
        private final String elementName;

        public static ProductAddedModalForm.ProductAttributes parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final HashMap<String, IBaseElement> elements = new HashMap<>()
    {
        {
            put(ProductAttributes.QUANTITY.elementName, quantityTxt);
        }
    };

    public ProductAddedModalForm() {
        super(By.cssSelector(".cart-content-btn .btn-secondary"), "'Proceed to checkout' button");
    }

    public String getAttributeValue(String attribute)
    {
        return ((Text) elements.get(attribute)).getTextValue();
    }
}
