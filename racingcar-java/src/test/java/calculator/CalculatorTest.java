package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈")
    void 문자열계산기_덧셈() {
        assertThat(calculator.calculator("2 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈")
    void 문자열계산기_뺄셈() {
        assertThat(calculator.calculator("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void 문자열계산기_곱셈() {
        assertThat(calculator.calculator("3 * 2")).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈")
    void 문자열계산기_나눗셈() {
        assertThat(calculator.calculator("9 / 3")).isEqualTo(3);
    }

    @Test
    @DisplayName("null")
    void 문자열계산기_null() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator.calculator(null)
                ).withMessageMatching("입력값이 null 임");
    }

    @Test
    @DisplayName("숫자 아님")
    void 문자열계산기_숫자아님() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator.calculator("ㅋㅋ")
                ).withMessageMatching("숫자 아닌 값 포함");
    }

    @Test
    @DisplayName("사칙연산 아님")
    void 문자열계산기_사칙연산아님() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator.calculator("1 ㅋㅋ")
                ).withMessageMatching("사칙연산이 아님");
    }

    @Test
    @DisplayName("공백 포함")
    void 문자열계산기_공백포함() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator.calculator("1  + 3")
                ).withMessageMatching("공백 포함");
    }

    @Test
    @DisplayName("사칙연산 모두 포함")
    void 문자열계산기_사칙연산산() {
        assertThat(calculator.calculator("2 + 3 * 4 / 2 - 5")).isEqualTo(5);
    }
}
