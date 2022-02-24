package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    @DisplayName("입력값 테스트 : 입력 문자열의 작성된 순서대로 연산한 결과가 기댓값과 동일해야 한다.")
    void calculate() {

        // Arrange
        var expect = 12;
        var input = "3 + 3 * 4 / 2";

        // Act
        var result = StringCalculator.calculate(input, new WhiteSpaceDelimiterSupplier().supply());

        // Assert
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("입력값 테스트 : 입력된 문자열의 숫자와 연산자의 수가 같다면 예외가 발생해야 한다.")
    void calculate_input_validation() {

        // Arrange
        var input = "3 + 3 +";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculate(input, new WhiteSpaceDelimiterSupplier().supply()));
    }

    @Test
    @DisplayName("입력값 테스트 : 연산자로 와야할 위치에 숫자가 온다면 예외가 발생해야 한다.")
    void calculate_duplicate_number_validation() {

        // Arrange
        var input = "3 + 3 * 4 2 /";

        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> StringCalculator.calculate(input, new WhiteSpaceDelimiterSupplier().supply()));
    }

    @Test
    @DisplayName("입력값 테스트 : 숫자가 와야할 위치에 연산자가 온다면 예외가 발생해야 한다.")
    void calculate_duplicate_operation_validation() {

        // Arrange
        var input = "3 + 3 * 4 / / 2";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculate(input, new WhiteSpaceDelimiterSupplier().supply()));
    }
}
