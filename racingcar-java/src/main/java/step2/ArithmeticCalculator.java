package step2;

import java.util.function.BiFunction;

public enum ArithmeticCalculator {

    ADD("+",(x, y) -> x + y);

    private String operator;
    private BiFunction<Integer, Integer, Integer> biFunction;

    ArithmeticCalculator(final String operator , final BiFunction<Integer, Integer, Integer> biFunction){
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static int arithmeticCalculator(final String operator, final int x, final int y){
        return getOperator(operator).biFunction.apply(x,y);
    }

    private static ArithmeticCalculator getOperator(final String operator){
        return ArithmeticCalculator.valueOf(operator);
    }

}
