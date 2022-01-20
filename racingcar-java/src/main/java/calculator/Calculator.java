package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String[] operation = {"+", "-", "*", "/"};
    private static final Pattern STRING_NUMBER = Pattern.compile("^[0-9]*$");

    int calculator(String input) {
        isNull(input);

        String[] splitStr = input.split(" ");

        int answer = 0;
        String currentOperation = "+";

        for (int i = 0; i < splitStr.length; i++) {
            // 공백인지 모든 경우 검사
            isEmpty(splitStr[i]);

            // 숫자일 경우
            if (i % 2 == 0) {
                switch (currentOperation) {
                    case "+":
                        answer += isNumber(splitStr[i]);
                        break;
                    case "-":
                        answer -= isNumber(splitStr[i]);
                        break;
                    case "*":
                        answer *= isNumber(splitStr[i]);
                        break;
                    case "/":
                        answer /= isNumber(splitStr[i]);
                        break;
                }
            }

            // 사칙연산일 경우
            else {
                currentOperation = isOperation(splitStr[i]);
            }
        }
        return answer;
    }

    private String isOperation(String oper) {
        for (String str : operation) {
            if (str.equals(oper)) {
                return oper;
            }
        }
        throw new IllegalArgumentException("사칙연산이 아님");
    }

    private void isEmpty(String str) {
        // 인풋 자체에 "  "가 있을경우 공백이 포함될 경우도 있다.
        if (str.isEmpty()) {
            throw new IllegalArgumentException("공백 포함");
        }
    }

    private void isNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("입력값이 null 임");
        }
    }

    private int isNumber(String str) {
        if (!STRING_NUMBER.matcher(str).matches()) {
            throw new IllegalArgumentException("숫자 아닌 값 포함");
        }
        return Integer.parseInt(str);
    }
}
