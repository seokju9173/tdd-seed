package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NameSpliter {

    private final static String delimeter = ",";

    public static List<Name> nameSplit(String string) {
        String[] strings = string.split(delimeter);
        return IntStream.range(0, strings.length)
                .mapToObj(i -> new Name(strings[i]))
                .collect(Collectors.toList());
    }
}
