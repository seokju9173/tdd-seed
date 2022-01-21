package mission02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 계산기테스트이므로, input과 output에 대해서 체크만 한다.
 */

public class CalculatorTest {


    @DisplayName("올바른 식의 형태 - 정상 값")
    @ParameterizedTest
    @CsvSource({"1 + 2 + 3 * 4, 24", "2 * 3 / 3 - 1, 1", "2 * 3 * 4 - 4, 20"})
    void 문자열에_올바른_식을_넣으면_의도대로_계산된_값이_나온다(String input, int output){
        // when
        final Calculator calculator = new Calculator(input);
        final int result = calculator.getCalculatorValue();

        // then
        assertThat(result).isEqualTo(output); // That : 지칭, Equal : 비교
    }

    @Test
    @DisplayName("올바르지 않은 식 형태 - 빈 공간이거나 입력값이 없을 시")
    void 문자열이_빈공간이나_입력값이_잘못되었을때_IllegalArgumentException을_터트린다(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("2 + * 10");
            int result = calculator.getCalculatorValue();
            assertThat(0).isEqualTo(result);
        }).withMessageMatching("cannot Read Expression");
    }

    @Test
    @DisplayName("올바르지 않은 식 형태 - 0으로 나눌 시")
    void 문자열에_올바르지_않는_숫자인_영으로_나눌때_IllegalArgumentException을_터트린다(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("1 + 2 + 3 + 4 + 5 / 0");
            int result = calculator.getCalculatorValue();
            assertThat(0).isEqualTo(result);
        }).withMessageMatching("cannot be divided by zero");
    }

    @Test
    @DisplayName("올바르지 않은 식 형태 - 사칙연산 기호가 아닐 시")
    void 문자열이_올바르지_않는_사칙연산이_들어왔을때_llegalArgumentException을_터트린다(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("2 ^ 5 & 1 # 5");
            int result = calculator.getCalculatorValue();
            assertThat(0).isEqualTo(result);
        }).withMessageMatching("operation is not arithmetic operation");
    }
}
