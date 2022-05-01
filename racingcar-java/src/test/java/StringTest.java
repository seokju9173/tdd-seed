import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("문자열을 ,로 분리")
    void splitTest() {
        Assertions.assertAll(
                () -> assertThat("1,2".split(",")).contains("1", "2"),
                () -> assertThat("1".split(",")).containsExactly("1")
        );
    }

    @Test
    @DisplayName("부분문자열 추출 테스트")
    void bracketRemoveTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 위치 값을 벗어나는 부분 확인")
    void charAtExceptionTest() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
