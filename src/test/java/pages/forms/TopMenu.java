package pages.forms;

import services.element.MenuItem;
import interfaces.element.IBaseElement;
import interfaces.enums.IEnumParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import services.page.BaseForm;

import java.util.HashMap;

public class TopMenu extends BaseForm {

    @AllArgsConstructor
    public enum TopMenuElements implements IEnumParser {
        CLOTHES("Clothes"),
        ACCESSORIES("Accessories"),
        ART("Art");

        @Getter
        private final String elementName;

        public static TopMenu.TopMenuElements parse(String input) {
            return IEnumParser.parse(input, values());
        }
    }

    private final MenuItem clothesMenuItem = new MenuItem(By.cssSelector("#top-menu > #category-3"), "'Clothes' menu item");
    private final MenuItem accessoriesMenuItem = new MenuItem(By.cssSelector("#top-menu > #category-6"), "'Accessories' menu item");
    private final MenuItem artMenuItem = new MenuItem(By.cssSelector("#top-menu > #category-9"), "'Art' menu item");

    private final HashMap<String, IBaseElement> elements = new HashMap<>()
    {
        {
            put(TopMenuElements.CLOTHES.elementName, clothesMenuItem);
            put(TopMenuElements.ACCESSORIES.getElementName(), accessoriesMenuItem);
            put(TopMenuElements.ART.elementName, artMenuItem);
        }
    };

    public TopMenu() {
        super(By.cssSelector("#top-menu"), "Top Menu");
    }

    public void clickTopMenuElement(TopMenuElements menuItem)
    {
        elements.get(menuItem.elementName).click();
    }
}
