package com.github.prestashop.cucumber;

import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.interfaces.element.IClickableElement;
import com.github.prestashop.services.element.*;

import java.util.HashMap;
import java.util.List;

public class ElementsHelper {
    public static void verifyElements(IElementsHelper pageInstance, List<ElementDto> expectedElementsCollection) {
        var elements = pageInstance.getElementsMap();
        expectedElementsCollection.forEach(elementDto -> {
            if (elements.containsKey(elementDto.getElementName())) {
                var exactElement = elements.get(elementDto.getElementName());

                if (exactElement instanceof Text) {
                    var expTextValue = elementDto.getElementValue();
                    var actTextValue = ((Text) exactElement).getTextValue();
                    AssertHelper.assertEquals(actTextValue, expTextValue,
                            String.format("Expected value for '%s' is '%s'", elementDto.getElementName(), expTextValue), false);
                }
            } else {
                throw new IllegalArgumentException(String
                        .format("The '%s' element name is not found in map from '%s'.",
                                elementDto.getElementName(), pageInstance.getClass().getName()));
            }
        });
    }

    public static void configureElements(IElementsHelper helper, List<ElementDto> elementDTOS){
        HashMap<String, BaseElement> elements = helper.getElementsMap();
        elementDTOS.forEach(elementDTO -> {
            if (elements.containsKey(elementDTO.getElementName())){
                var exactElement = elements.get(elementDTO.getElementName());
                var elementValue = elementDTO.getElementValue();

                if (exactElement instanceof TextBox){
                    ((TextBox)(exactElement)).clearAndType(elementValue);
                }
                else if (exactElement instanceof IClickableElement){
                    exactElement.click();
                } else if (exactElement instanceof DropDown)
                {
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
