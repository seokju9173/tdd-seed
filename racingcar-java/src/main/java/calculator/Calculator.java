package calculator;

import java.util.Objects;

public class Calculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTI = "*";
    private static final String BLANK = " ";

    int calculator(String input) {
        checkIsNull(input);

        String[] splitStr = input.split(BLANK);
        checkIsEmpty(splitStr);

        int answer = parseInt(splitStr[0]);

        for (int i = 1; i < splitStr.length - 1; i += 2) {
            answer = calculate(answer, splitStr[i], parseInt(splitStr[i + 1]));
        }
        return answer;
    }

    private int calculate(int firstValue, String operator, int secondValue) {
        if (operator.equals(PLUS))
            return add(firstValue, secondValue);
        if (operator.equals(MINUS))
            return subtract(firstValue, secondValue);
        if (operator.equals(MULTI))
            return multiply(firstValue, secondValue);
        if (operator.equals(DIVIDE))
            return divide(firstValue, secondValue);
        throw new IllegalArgumentException("사칙연산이 아님");
    }

    private int add(int i, int j) {
        return i + j;
    }

    private int subtract(int i, int j) {
        return i - j;
    }

    private int multiply(int i, int j) {
        return i * j;
    }

    private int divide(int i, int j) {
        // 나눗셈의 결과는 문제에서 정수로 떨어지는 결과에 한정하여
        // 굳이 divide by zero 처리는 하지 않음
        return i / j;
    }

    private void checkIsEmpty(String[] str) {
        // 인풋 자체에 "  "가 있을경우 공백이 포함될 경우도 있다.
        for (int i = 0; i < str.length; i++) {
            if (str[i].isEmpty()) {
                throw new IllegalArgumentException("공백 포함");
            }
        }
    }

    private void checkIsNull(String str) {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("입력값이 null 임");
        }
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 아닌 값 포함");
        }
    }
}
