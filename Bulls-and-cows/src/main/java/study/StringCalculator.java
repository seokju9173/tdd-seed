package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static int calculate(String input, String delimiter) {
        return calculate(
                extract(input.split(delimiter), StringCalculator::isNumber, Integer::parseInt),
                extract(input.split(delimiter), StringCalculator::isNotNumber, String::valueOf)
        );
    }

    public static int calculate(List<Integer> values, List<String> operation) {
        Integer result = values.get(ZERO);
        int lastIndex = operation.size() + ONE;
        for (int index = ONE; index < lastIndex; index++) {
            result = OperationMap.getOperator(operation.get(index - ONE)).apply(result, values.get(index));
        }
        return result;
    }

    public static <T, R> List<R> extract(T[] input, Predicate<T> predicate, Function<T, R> function) {
        return Arrays.stream(input)
                .filter(predicate)
                .map(function)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static boolean isNotNumber(String s) {
        boolean isPlus = s.equals("+");
        boolean isMinus = s.equals("-");
        boolean isDivide = s.equals("*");
        boolean isMultiply = s.equals("/");
        return isPlus || isMinus || isDivide || isMultiply;
    }

    private static boolean isNumber(String s) {
        return !isNotNumber(s);
    }
}
