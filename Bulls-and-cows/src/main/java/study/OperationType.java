package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationType {
    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    DIVIDE("*", Math::multiplyExact),
    MULTIPLY("/", Math::floorDiv);

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> function;

    OperationType(String operation, BiFunction<Integer, Integer, Integer> function) {
        this.operation = operation;
        this.function = function;
    }

    public Integer apply(Integer bucket, Integer value) {
        return function.apply(bucket, value);
    }

    public static OperationType getOperator(String operation) {
        return Arrays.stream(OperationType.values())
                .filter(operationType -> operationType.operation.equals(operation))
                .findAny()
                .orElseThrow(UnsupportedOperationException::new);
    }
}
