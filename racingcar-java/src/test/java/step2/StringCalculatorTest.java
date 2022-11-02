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
    void substractionTest() {
        assertThat(4).isEqualTo(stringCalculator.substraction(7,3));
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
}
