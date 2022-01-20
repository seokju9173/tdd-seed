package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("문자열계산기 덧셈")
    void calculatorPlusTest() {
        assertThat(calculator.calculator("2 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("문자열계산기 뺄셈")
    void calculatorMinusTest() {
        assertThat(calculator.calculator("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열계산기 곱셈")
    void calculatorMultiTest() {
        assertThat(calculator.calculator("3 * 2")).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열계산기 나눗셈")
    void calculatorDivideTest() {
        assertThat(calculator.calculator("9 / 3")).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열계산기 null 테스트")
    void calculatorNullTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculator(null)
                ).withMessageMatching("입력값이 null 임");
    }

    @Test
    @DisplayName("문자열계산기 숫자 아님")
    void calculatorNotNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculator("ㅋㅋ")
                ).withMessageMatching("숫자 아닌 값 포함");
    }

    @Test
    @DisplayName("문자열계산기 사칙연산 아님")
    void calculatorNotOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculator("1 ㅋㅋ 1")
                ).withMessageMatching("사칙연산이 아님");
    }

    @Test
    @DisplayName("문자열계산기 공백 포함")
    void calculatorIncludeBlank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculator("")
                ).withMessageMatching("공백 포함");
    }

    @Test
    @DisplayName("문자열계산기 식에 공백 포함")
    void calculatorIncludeBlank2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculator("1 +  3")
                ).withMessageMatching("공백 포함");
    }
    
    @Test
    @DisplayName("문자열계산기 사칙연산 모두 포함")
    void calculatorAllOperation() {
        assertThat(calculator.calculator("2 + 3 * 4 / 2 - 5")).isEqualTo(5);
    }
}
