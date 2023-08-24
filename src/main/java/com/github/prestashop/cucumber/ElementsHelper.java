package com.github.prestashop.cucumber;

import com.github.prestashop.cucumber.dto.ElementDto;
import com.github.prestashop.helpers.AssertHelper;
import com.github.prestashop.interfaces.cucumber.IElementsHelper;
import com.github.prestashop.services.element.Text;

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
}
