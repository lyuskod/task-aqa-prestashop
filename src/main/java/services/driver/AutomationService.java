package services.driver;

import factory.BrowserFactory;
import interfaces.driver.IAutomationService;

public class AutomationService implements IAutomationService {

    private final BaseDriver driver;
    private final ElementsCollection elementsCollection;
    private static AutomationService instance;

    private AutomationService()
    {
        this.driver = BrowserFactory.getDriver(BrowserFactory.BrowserTypes.FIREFOX);
        this.elementsCollection = new ElementsCollection(this.driver);
    }

    public static AutomationService get() {
        if (AutomationService.instance == null) {
            AutomationService.instance = new AutomationService();
        }
        return AutomationService.instance;
    }

    public BaseDriver browser()
    {
        return this.driver;
    }

    public ElementsCollection elements()
    {
        return this.elementsCollection;
    }
}
