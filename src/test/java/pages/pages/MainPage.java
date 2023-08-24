package pages.pages;

import org.openqa.selenium.By;
import pages.forms.TopMenu;
import com.github.prestashop.services.page.BaseForm;

public class MainPage extends BaseForm {

    private final TopMenu topMenu;

    public MainPage() {
        super(By.cssSelector("section[class='featured-products clearfix']"), "Popular Products");
        this.topMenu = new TopMenu();
    }

    public TopMenu topMenu() {
        return this.topMenu;
    }
}
