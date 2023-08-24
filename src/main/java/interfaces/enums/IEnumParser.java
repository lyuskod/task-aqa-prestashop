package interfaces.enums;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;

public interface IEnumParser {
    String name();

    default String getDisplayedName() {
        return WordUtils.capitalizeFully(name().replace("_", " "));
    }

    static <T extends IEnumParser> T parse(String value, T[] values) {
        return Arrays.stream(values).filter(item -> item.getDisplayedName().equalsIgnoreCase(value)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
