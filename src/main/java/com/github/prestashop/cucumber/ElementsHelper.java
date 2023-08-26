package com.github.prestashop.cucumber;

import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.interfaces.cucumber.IElementsMap;
import com.github.prestashop.interfaces.element.IClickableElement;
import com.github.prestashop.services.element.*;
import com.github.prestashop.services.logger.BaseLogger;

import java.util.HashMap;
import java.util.List;

public class ElementsHelper {
    private static final BaseLogger logger = BaseLogger.getLogger(ElementsHelper.class);

    public static void verifyElements(IElementsMap pageInstance, List<ElementDto> expectedElementsCollection) {
        var elements = pageInstance.getElementsMap();
        expectedElementsCollection.forEach(elementDto -> {
            if (elements.containsKey(elementDto.getElementName())) {
                var exactElement = elements.get(elementDto.getElementName());

                if (exactElement instanceof Text) {
                    var expTextValue = elementDto.getElementValue();
                    var actTextValue = ((Text) exactElement).getTextValue();
                    logger.info(String.format("[READY]: Verify Text Element with name '%s' and locator '%s' to have value '%s'", exactElement.getName(), exactElement.getLocator(), expTextValue));
                    AssertHelper.assertEquals(actTextValue, expTextValue,
                            String.format("Expected value for '%s' element with '%s' locator is '%s'", elementDto.getElementName(), exactElement.getLocator(), expTextValue), false);
                    logger.info(String.format("[SUCCESS]: Verify Text Element with name '%s' and locator '%s'", exactElement.getName(), exactElement.getLocator()));
                }
            } else {
                throw new IllegalArgumentException(String
                        .format("The '%s' element name is not found in map from '%s'.",
                                elementDto.getElementName(), pageInstance.getClass().getName()));
            }
        });
    }

    public static void configureElements(IElementsMap helper, List<ElementDto> elementDTOS) {
        HashMap<String, BaseElement> elements = helper.getElementsMap();
        elementDTOS.forEach(elementDTO -> {
            if (elements.containsKey(elementDTO.getElementName())) {
                var exactElement = elements.get(elementDTO.getElementName());
                var elementValue = elementDTO.getElementValue();

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
                                elementDTO.getElementName(), helper.getClass().getName()));
            }
        });
    }
}
