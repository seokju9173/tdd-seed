import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

final class StringTest {

    @Test
    public final void splitTest() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    public final void bracketRemoveTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 위치 값을 벗어나는 부분 확인")
    public final void charAtExceptionTest() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
