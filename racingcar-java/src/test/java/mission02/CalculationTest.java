package mission02;

import mission02.exception.DividedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTest {

    private final Calculation calculation = new Calculation();

    @DisplayName("연산기호 테스트 - +, -, *, /")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 연산기호가_올바른_사칙연산의_연산기호인지_확인한다(String type){
        // given
        final String[] types = {Calculation.PLUS, Calculation.MINUS, Calculation.MULTIPLY, Calculation.DIVIDED};

        // when
        boolean result = Arrays.asList(types)
                .contains(type);

        // then
        assertTrue(result);
    }

    @DisplayName("연산기호\'+\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3", "2, 3, 5", "5, 100, 105"})
    void 두개의_값이_주어지고_합하면_올바른_값이_나온다(int baseOperand, int nextOperand, int expected){
        // given
        final String operator = Calculation.PLUS;

        // when
        int calcResult = calculation.calculate(baseOperand, operator, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(expected);
    }

    @DisplayName("연산기호\'-\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 1", "5, 2, 3", "100, 10, 90"})
    void 두개의_값이_주어지고_빼면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // given
        final String operator = Calculation.MINUS;

        // when
        int calcResult = calculation.calculate(baseOperand, operator, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'*\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 6", "5, 2, 10", "100, 10, 1000"})
    void 두개의_값이_주어지고_곱하면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // given
        final String operator = Calculation.MULTIPLY;

        // when
        int calcResult = calculation.calculate(baseOperand, operator, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'/\' 테스트 - 0이 아닌 값으로 나눌 때")
    @ParameterizedTest
    @CsvSource(value = {"4, 2, 2", "6, 1, 6", "100, 1, 100"})
    void 두개의_값이_주어지고_나누면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // given
        final String operator = Calculation.DIVIDED;

        // when
        int calcResult = calculation.calculate(baseOperand, operator, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'/\' 테스트 - 0으로 나눌 때")
    @ParameterizedTest
    @CsvSource(value = {"100,0", "5, 0", "3, 0"})
    void 두개의_값이_주어지고_0으로_나누면_Exception이_터진다(int baseOperand, int nextOperand){

        final String operator = Calculation.DIVIDED;

        assertThatThrownBy(() -> calculation.calculate(baseOperand, operator, nextOperand))
                .isInstanceOf(DividedException.class)
                .hasMessage("cannot be divided by zero");
    }
}