import java.util.Objects;

public class Calculator {

    private static final String BLANK = " ";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    int calculate(String input) {
        checkNullOrEmpty(input);

        String[] data = input.split(BLANK);
        checkInputLength(data);

        checkValidNumber(data[0]);
        int result = Integer.parseInt(data[0]);

        for (int i = 1; i < data.length; i += 2) {
            checkValidOperator(data[i]);
            String operator = data[i];

            checkValidNumber(data[i+1]);
            int num = Integer.parseInt(data[i+1]);

            result = operate(result, operator, num);

        }
        return result;
    }

    private int operate(int result, String operator, int num) {
        if (operator.equals(PLUS)) {
            result = plus(result, num);
        } else if (operator.equals(MULTIPLY)) {
            result = multiply(result, num);
        } else if (operator.equals(MINUS)) {
            result = minus(result, num);
        } else if (operator.equals(DIVIDE)) {
            result = divide(result, num);
        }
        return result;
    }

    private int divide(int result, int num) {
        checkDividingNumber(num);
        return result / num;
    }

    private int minus(int result, int num) {
        return result - num;
    }

    private int multiply(int result, int num) {
        return result * num;
    }

    private int plus(int result, int num) {
        return result + num;
    }

    private void checkDividingNumber(int num) {
        if (num == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다");
        }
    }

    private void checkValidNumber(String numStr) {
        if (!numStr.matches("[0-9]+[\\.]?[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

    }

    private void checkValidOperator(String op) {
        if (!op.equals(PLUS) && !op.equals(MINUS) && !op.equals(MULTIPLY) && !op.equals(DIVIDE)) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다");
        }
    }

    private void checkInputLength(String[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("2개 이상의 값을 입력해주세요");
        }
    }

    private void checkNullOrEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("input 값이 잘못되었습니다");
        }
    }

}
