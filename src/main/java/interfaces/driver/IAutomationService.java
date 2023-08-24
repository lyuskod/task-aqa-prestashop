package interfaces.driver;

import services.driver.BaseDriver;
import services.driver.ElementsCollection;

public interface IAutomationService {

    BaseDriver browser();
    ElementsCollection elements();
}
