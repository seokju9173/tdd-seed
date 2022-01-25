package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationMap {
    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("*", (a, b) -> a * b),
    MULTIPLY("/", (a, b) -> a / b),
    NONE("", (a, b) -> null);
    private final String operation;
    private final BiFunction<Integer, Integer, Integer> function;

    OperationMap(String operation, BiFunction<Integer, Integer, Integer> function) {
        this.operation = operation;
        this.function = function;
    }

    public Integer apply(Integer bucket, Integer value) {
        return function.apply(bucket, value);
    }

    public static OperationMap getOperator(String operation) {
        return Arrays.stream(OperationMap.values())
                .filter(operationMap -> operationMap.operation.equals(operation))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
