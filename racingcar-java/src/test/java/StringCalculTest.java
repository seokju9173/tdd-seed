import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculTest {
    private static final String[] operation = {"+", "-", "*", "/"};
    private static final Pattern STRING_NUMBER = Pattern.compile("^[0-9]*$");

    @Test
    @DisplayName("덧셈")
    void 문자열계산기_덧셈() {
        assertThat(calculator("2 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈")
    void 문자열계산기_뺄셈() {
        assertThat(calculator("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void 문자열계산기_곱셈() {
        assertThat(calculator("3 * 2")).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈")
    void 문자열계산기_나눗셈() {
        assertThat(calculator("9 / 3")).isEqualTo(3);
    }

    @Test
    @DisplayName("null")
    void 문자열계산기_null() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator(null)
                ).withMessageMatching("입력값이 null 임");
    }

    @Test
    @DisplayName("숫자 아님")
    void 문자열계산기_숫자아님() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator("ㅋㅋ")
                ).withMessageMatching("숫자 아닌 값 포함");
    }

    @Test
    @DisplayName("사칙연산 아님")
    void 문자열계산기_사칙연산아님() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator("1 ㅋㅋ")
                ).withMessageMatching("사칙연산이 아님");
    }

    @Test
    @DisplayName("공백 포함")
    void 문자열계산기_공백포함() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator("1  + 3")
                ).withMessageMatching("공백 포함");
    }

    @Test
    @DisplayName("사칙연산 모두 포함")
    void 문자열계산기_사칙연산산() {
        assertThat(calculator("2 + 3 * 4 / 2 - 5")).isEqualTo(5);
    }

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
