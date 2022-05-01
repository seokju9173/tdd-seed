package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기")
public class CalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("문자열 연산 테스트")
    void calculationTest() {
        String str = "2 + 3 * 4 / 2";

        assertThat(calculator.calculation(str)).isEqualTo(10);
    }

    @Test
    @DisplayName("덧셈 연산 테스트")
    void addTest() {
        String str = "2 + 3";

        assertThat(calculator.calculation(str)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    void minusTest() {
        String str = "3 - 1";

        assertThat(calculator.calculation(str)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    void multiplicationTest() {
        String str = "2 * 3";

        assertThat(calculator.calculation(str)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 연산 테스트")
    void divisionTest() {
        String str = "4 / 2";

        assertThat(calculator.calculation(str)).isEqualTo(2);
    }
}
