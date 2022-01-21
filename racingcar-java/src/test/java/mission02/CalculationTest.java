package mission02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTest {

    Calculation calculation = new Calculation();
    String[] types = {OperatorType.PLUS, OperatorType.MINUS, OperatorType.MULTIPLY, OperatorType.DIVIDED};

    @DisplayName("연산기호 테스트 - +, -, *, /")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 연산기호가_올바른_사칙연산의_연산기호인지_확인한다(String type){ // 이거 리뷰 필요
        // when
        boolean check = Arrays.stream(types).anyMatch(type::equals);

        // then
        assertTrue(check);
    }

    @DisplayName("연산기호\'+\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3", "2, 3, 5", "5, 100, 105"})
    void 두개의_값이_주어지고_합하면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // when
        int calcResult = calculation.splitCalculation(baseOperand, OperatorType.PLUS, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'-\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 1", "5, 2, 3", "100, 10, 90"})
    void 두개의_값이_주어지고_빼면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // when
        int calcResult = calculation.splitCalculation(baseOperand, OperatorType.MINUS, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'*\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 6", "5, 2, 10", "100, 10, 1000"})
    void 두개의_값이_주어지고_곱하면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // when
        int calcResult = calculation.splitCalculation(baseOperand, OperatorType.MULTIPLY, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }

    @DisplayName("연산기호\'/\' 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4, 2, 2", "6, 1, 6", "100, 1, 100"})
    void 두개의_값이_주어지고_나누면면_올바른_값이_나온다(int baseOperand, int nextOperand, int result){
        // when
        int calcResult = calculation.splitCalculation(baseOperand, OperatorType.DIVIDED, nextOperand);

        // then
        assertThat(calcResult).isEqualTo(result);
    }
}

/**
 * 이 부분에서 질문 2가지
 * 1. +,-,/,* 를 enum타입으르 쓸 수 없을까요?
 * 2. 더해주고 빼주는 그 부분만 테스트하고 싶은데, 그렇다면 함수들의 접근제어자를 private로 하는 게 맞을까요?
 */