package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("문자열 분리")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("문자열 분리, 원소가 정확히 일치")
    void splitExactlyTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("문자열 자르기")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void charAtTest() {
        String string = "abc";
        char result = string.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외 발생")
    void charAtExceptionTest() {
        String string = "abc";
        assertThatThrownBy(() -> string.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
