package helpers;

import services.driver.AutomationService;
import extentions.StringExtensions;
import io.qameta.allure.Allure;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AllureHelper {

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
        byte[] byteArray = AutomationService.get().browser().window().getScreenshot();
        Allure.addByteAttachmentAsync(IMAGE_DEFINITION + StringExtensions.generateRandomString(),
                AttachmentFormats.Image_PNG.getFormat(), () -> byteArray);
        return byteArray;
    }
}
