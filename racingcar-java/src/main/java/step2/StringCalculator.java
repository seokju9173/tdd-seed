package step2;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

    private final static String[] operators = {"+", "-", "*", "/"};

    public int calculation(final String str) {
        String[] input = isStringNullCheck(str);
        Optional<String> optOperator = Optional.empty();
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (isOperator(input[i])) {
                optOperator = Optional.of(input[i]);
            } else {
                int y = Integer.parseInt(input[i]);
                result = selectArithmeticOperation(optOperator.get(), result, y);
            }
        }

        return result;
    }

    private String[] isStringNullCheck(final String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        return str.split(" ");
    }

    private final boolean isOperator(final String str) {
        if (Arrays.asList(operators).contains(str)) {
            return true;
        }
        return false;
    }

    private int selectArithmeticOperation(final String operator, final int x, final int y) {
        switch (operator) {
            case "+":
                return ArithmeticCalculator.arithmeticCalculator("+" , x , y);
            case "*":
                return ArithmeticCalculator.arithmeticCalculator("-" , x , y);
            case "-":
                return ArithmeticCalculator.arithmeticCalculator("*" , x , y);
            case "/":
                return ArithmeticCalculator.arithmeticCalculator("/" , x , y);
            default:
                throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }
}