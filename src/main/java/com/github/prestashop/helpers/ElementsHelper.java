package com.github.prestashop.helpers;

import com.github.prestashop.helpers.models.ElementModel;
import com.github.prestashop.interfaces.cucumber.IElementsMap;
import com.github.prestashop.interfaces.element.IClickableElement;
import com.github.prestashop.services.element.*;
import com.github.prestashop.services.logger.BaseLogger;

import java.util.HashMap;
import java.util.List;

public class ElementsHelper {
    private static final BaseLogger logger = BaseLogger.getLogger(ElementsHelper.class);

    public static void verifyElements(IElementsMap pageInstance, List<ElementModel> expectedElementsCollection) {
        var elements = pageInstance.getElementsMap();
        expectedElementsCollection.forEach(elementModel -> {
            if (elements.containsKey(elementModel.getElementName())) {
                var exactElement = elements.get(elementModel.getElementName());

                if (exactElement instanceof Text) {
                    var expTextValue = elementModel.getElementValue();
                    var actTextValue = ((Text) exactElement).getTextValue();
                    logger.info(String.format("[READY]: Verify Text Element with name '%s' and locator '%s' to have value '%s'", exactElement.getName(), exactElement.getLocator(), expTextValue));
                    AssertHelper.assertEquals(actTextValue, expTextValue,
                            String.format("Expected value for '%s' element with '%s' locator is '%s'", elementModel.getElementName(), exactElement.getLocator(), expTextValue), false);
                    logger.info(String.format("[SUCCESS]: Verify Text Element with name '%s' and locator '%s'", exactElement.getName(), exactElement.getLocator()));
                }
            } else {
                throw new IllegalArgumentException(String
                        .format("The '%s' element name is not found in map from '%s'.",
                                elementModel.getElementName(), pageInstance.getClass().getName()));
            }
        });
    }

    public static void configureElements(IElementsMap helper, List<ElementModel> elementModels) {
        HashMap<String, BaseElement> elements = helper.getElementsMap();
        elementModels.forEach(elementModel -> {
            if (elements.containsKey(elementModel.getElementName())) {
                var exactElement = elements.get(elementModel.getElementName());
                var elementValue = elementModel.getElementValue();

                if (exactElement instanceof TextBox) {
                    ((TextBox) (exactElement)).clearAndType(elementValue);
                } else if (exactElement instanceof IClickableElement) {
                    exactElement.click();
                } else if (exactElement instanceof DropDown) {
                    ((DropDown) (exactElement)).selectByVisibleText(elementValue);
                }
            } else {
                throw new IllegalArgumentException(String
                        .format("The '%s' element name is not found in map from '%s'.",
                                elementModel.getElementName(), helper.getClass().getName()));
            }
        });
    }
}
