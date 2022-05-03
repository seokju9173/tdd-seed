import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator sc = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 3:4", "1234 + 5678:6912"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void addTest(String input, int expected) {
        assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "3 - 1:2", "0 - 0:0"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtractTest(String input, int expected) {
        assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "3 * 0:0"}, delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multipleTest(String input, int expected) {
        assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0", "2 / 1:2", "0 / 2:0"}, delimiter = ':')
    @DisplayName("나눗셈 성공 테스트")
    void divideSuccessTest(String input, int expected) {
        assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈 실패 테스트")
    void divideFailTest() {
        assertThatExceptionOfType(ArithmeticException.class)
                        .isThrownBy(() -> {
                            sc.calculate("2 / 0");
                        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, 공백 문자열 테스트")
    void emptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            sc.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1 ; 2", "0 ~ 3"})
    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    void symbolTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            sc.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 / 2 * 3 + 4 - 5:-1"}, delimiter = ':')
    @DisplayName("종합 사칙연산 성공 테스트")
    void arithmeticSuccessTest(String input, int expected) {
        assertThat(sc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 *", "2 + * 3"})
    @DisplayName("종합 사칙연산 실패 테스트")
    void arithmeticFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            sc.calculate(input);
        });
    }
}
