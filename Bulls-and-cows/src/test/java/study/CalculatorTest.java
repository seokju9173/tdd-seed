package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("계산기 테스트 : 입력 문자열의 작성된 순서대로 연산한 결과가 기댓값과 동일해야 한다.")
    void calculate() {
        // Arrange
        var expect = 12;
        var input = "3 + 3 * 4 / 2";
        var delimiter = " ";

        // Act
        var result = StringCalculator.calculate(input, delimiter);

        // Assert
        assertEquals(expect, result);
    }
}
