package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void additionTest() {
        assertThat(10).isEqualTo(stringCalculator.addition(7,3));
    }
    
    @Test
    @DisplayName("뺄셈 테스트")
    void subtractionTest() {
        assertThat(4).isEqualTo(stringCalculator.subtraction(7,3));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplicationTest() {
        assertThat(21).isEqualTo(stringCalculator.multiplication(7,3));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest() {
        assertThat(2).isEqualTo(stringCalculator.division(6,3));
    }

    @Test
    @DisplayName("입력한 문자열 사이의 빈 공백으로 문자열이 분리되는지 테스트")
    void stringBlankSplitTest() {
        String inputString = "7 + 3";
        String[] result = inputString.split(" ");
        assertThat(result).containsExactly("7", "+", "3");
    }
    
    @Test
    @DisplayName("입력한 문자열이 연산자에 따라 계산되는지 테스트")
    void stringCalculateTest() {
        String inputString = "2 + 3 * 4 / 2";
        String[] result = stringCalculator.stringBlankSplit(inputString);
        int number = 10;
        assertThat(number).isEqualTo(stringCalculator.calculateString(result));
    }
}
