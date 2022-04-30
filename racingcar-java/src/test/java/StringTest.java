import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


public class StringTest {
    @Test
    void splitTest(){
        String[] str1 = "1,2".split(",");
        String[] str2 = "1".split(",");

        assertThat(str1).contains("1","2");
        assertThat(str2).contains("1");
    }

    @Test
    void subStringTest(){
        String str = "(1,2)".substring(1,4);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Exception 처리")
    void charAtTest(){
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
