package step2;

import java.util.function.BiFunction;

enum ArithmeticCalculator {

    ADD((x, y) -> x + y),
    MINUS((x, y) -> x - y),
    DIVISION((x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("0은 나눌 수 없습니다.");
        }
        return x / y;
    }),
    MULTIPLE((x, y) -> x * y);

    private BiFunction<Integer, Integer, Integer> biFunction;

    public int arithmeticCalculator(final int x, final int y) {
        return biFunction.apply(x, y);
    }

    ArithmeticCalculator(final BiFunction<Integer, Integer, Integer> biFunction) {
        this.biFunction = biFunction;
    }
}
