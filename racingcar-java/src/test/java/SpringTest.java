import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class SpringTest {

    @Test
    void stringTest1() {
        String st1 = "1,2";
        String[] stsp1 = st1.split(",");

        String st2 = "1";
        String[] stsp2 = st2.split(",");

        assertThat(stsp1).contains("1", "2");
        assertThat(stsp2).containsExactly("1");
    }

    @Test
    void stringTest2() {
        String st = "(1,2)";
        st = st.substring(1, 4);

        assertThat(st).isEqualTo("1,2");
    }

    @Test
    void stringTest3() {
        String st = "abc";

        assertAll(
                () -> assertThat(st.charAt(0)).isEqualTo('a'),
                () -> assertThat(st.charAt(1)).isEqualTo('b'),
                () -> assertThat(st.charAt(2)).isEqualTo('c'),
                () -> assertThatThrownBy(() -> st.charAt(3))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3")
        );
    }
}
