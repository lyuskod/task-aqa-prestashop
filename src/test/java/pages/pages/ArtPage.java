package pages.pages;

import org.openqa.selenium.By;
import services.page.BaseForm;

public class ArtPage extends BaseForm {
    public ArtPage() {
        super(By.cssSelector("section#main h1"), "Art page");
    }
}
