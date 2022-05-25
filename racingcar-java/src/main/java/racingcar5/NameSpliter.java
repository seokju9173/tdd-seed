package racingcar5;

import java.util.Arrays;
import java.util.List;

public class NameSpliter {

    private final static String DELIMITER_CHARACTER = ",";

    public static List<String> nameSplit(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("null / 공백 이름");
        }
        return Arrays.stream(string.split(DELIMITER_CHARACTER)).toList();
    }
}
