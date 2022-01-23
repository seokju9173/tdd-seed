package mission02;

import mission02.exception.DividedException;
import mission02.exception.InvalidExpressionException;
import mission02.exception.OperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 계산기테스트이므로, input과 output에 대해서 체크만 한다.
 */

public class CalculatorTest {

    final Calculator calculator = new Calculator();


    @DisplayName("올바른 식의 형태 - 정상 값")
    @ParameterizedTest
    @CsvSource({"1 + 2 + 3 * 4, 24", "2 * 3 / 3 - 1, 1", "2 * 3 * 4 - 4, 20"})
    void 문자열에_올바른_식을_넣으면_의도대로_계산된_값이_나온다(String input, int output){

        // when
        final int result = calculator.calculatorValue(input);

        // then
        assertThat(result).isEqualTo(output); // That : 지칭, Equal : 비교
    }

    @DisplayName("올바르지 않은 식 형태 - 숫자로 안끝나거나, 문자의 형태가 맞지 않을 때")
    @ParameterizedTest
    @CsvSource({"5 +", "5 -", "10 + 3 - 1 *", "5 + 3 +"})
    void 문자열이_숫자표현식에_맞지않을때_InvalidExpression_예외를_터트린다(String input){

        assertThatThrownBy(() -> {
            int calcResult = calculator.calculatorValue(input);
        })
                .isInstanceOf(InvalidExpressionException.class)
                .hasMessage("expression is invalid expression");
    }


    @DisplayName("올바르지 않은 식 형태 - 0으로 나눌 시")
    @ParameterizedTest
    @CsvSource({"10 / 0" , "5 / 0", "125 / 0"})
    void 문자열에_영으로_나누는_형식이_있다면_Divided_예외를_터트린다(String input){

        assertThatThrownBy(() -> {
            int calcResult = calculator.calculatorValue(input);
        })
                .isInstanceOf(DividedException.class)
                .hasMessage("cannot be divided by zero");
    }

    @DisplayName("올바르지 않은 식 형태 - 사칙연산 기호가 아닐 시")
    @ParameterizedTest
    @CsvSource({"5 & 1", "5 ^ 5", "3 ( 2"})
    void 문자열이_올바르지_않는_사칙연산이_들어왔을때_Format_예외를_터트린다(String input){

        assertThatThrownBy(() -> { int calcResult = calculator.calculatorValue(input); })
                .isInstanceOf(OperatorException.class)
                .hasMessage("operation is not arithmetic operation");
    }
}
