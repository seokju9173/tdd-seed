import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    Calculator c = new Calculator();

    @ParameterizedTest
    @DisplayName("calculate 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "3 * 10 - 6 / 2=12"}, delimiter = '=')
    void calculateTest(String input, int result) {
        assertThat(c.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("null 혹은 빈 공백 에러 테스트 ")
    @NullAndEmptySource
    void nullOrEmptyErrorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> c.calculate(input))
                .withMessageMatching("input 값이 잘못되었습니다");
    }

    @ParameterizedTest
    @DisplayName("연산자 에러 테스트")
    @ValueSource(strings = {"2 // 3 ) 4", "1 == 4"})
    void operatorErrorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> c.calculate(input))
                .withMessageMatching("유효한 연산자가 아닙니다");
    }

    @ParameterizedTest
    @DisplayName("Input 값이 2개 미만일 경우 에러 테스트")
    @ValueSource(strings = {"2 -", "3"})
    void inputLengthErrorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> c.calculate(input))
                .withMessageMatching("2개 이상의 값을 입력해주세요");
    }

    @ParameterizedTest
    @DisplayName("0으로 나눌 경우 에러 테스트")
    @ValueSource(strings = {"2 + 5 / 0", "3 / 0 * 10"})
    void divideByZeroErrorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> c.calculate(input))
                .withMessageMatching("0으로는 나눌 수 없습니다");
    }
}