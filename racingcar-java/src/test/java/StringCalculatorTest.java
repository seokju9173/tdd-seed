import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator sc = new StringCalculator();

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        Assertions.assertAll(
                () -> assertThat(sc.calculate("1 + 2")).isEqualTo(3),
                () -> assertThat(sc.calculate("1 + 3")).isEqualTo(4),
                () -> assertThat(sc.calculate("1234 + 5678")).isEqualTo(6912)
        );
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        Assertions.assertAll(
                () -> assertThat(sc.calculate("1 - 2")).isEqualTo(-1),
                () -> assertThat(sc.calculate("3 - 1")).isEqualTo(2),
                () -> assertThat(sc.calculate("0 - 0")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleTest() {
        Assertions.assertAll(
                () -> assertThat(sc.calculate("1 * 2")).isEqualTo(2),
                () -> assertThat(sc.calculate("3 * 0")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        Assertions.assertAll(
                () -> assertThat(sc.calculate("1 / 2")).isEqualTo(0),
                () -> assertThat(sc.calculate("2 / 1")).isEqualTo(2),
                () -> assertThatExceptionOfType(ArithmeticException.class)
                        .isThrownBy(() -> {
                            sc.calculate("2 / 0");
                        }),
                () -> assertThat(sc.calculate("0 / 2")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("null, 공백 문자열 테스트")
    void emptyTest() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate(null);
                }),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate("");
                }),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate(" ");
                })
        );
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    void symbolTest() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate("1 ; 2");
                }),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate("0 ~ 3");
                })
        );
    }

    @Test
    @DisplayName("종합 사칙연산 테스트")
    void arithmeticTest() {
        Assertions.assertAll(
                () -> assertThat(sc.calculate("2 + 3 * 4 / 2")).isEqualTo(10),
                () -> assertThat(sc.calculate("1 / 2 * 3 + 4 - 5")).isEqualTo(-1),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    sc.calculate("2 + 3 *");
                })
        );
    }
}
