package com.github.prestashop.helpers;

import com.github.prestashop.services.driver.Automation;
import com.github.prestashop.extensions.StringExtensions;
import com.github.prestashop.services.logger.BaseLogger;
import io.qameta.allure.Allure;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AllureHelper {
    private static BaseLogger logger = BaseLogger.getLogger(AllureHelper.class);

    public static final String IMAGE_DEFINITION = "Image-";

    @AllArgsConstructor
    public enum AttachmentFormats {
        Image_PNG("image/png");

        @Getter
        private final String format;
    }

    private AllureHelper() {
    }

    public static byte[] takeAndAttachScreenShot() {
        logger.info("[READY]: Take and attach screenshot to Allure");
        var byteArray = Automation.get().browser().window().getScreenshot();
        Allure.addByteAttachmentAsync(IMAGE_DEFINITION + StringExtensions.generateRandomString(),
                AttachmentFormats.Image_PNG.getFormat(), () -> byteArray);
        logger.info("[SUCCESS]: Take and attach screenshot to Allure");
        return byteArray;
    }
}
