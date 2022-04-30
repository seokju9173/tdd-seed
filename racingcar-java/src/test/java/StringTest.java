import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("문자열 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("split() 학습 테스트")
    void splitTest(){
        String[] str1 = "1,2".split(",");
        String[] str2 = "1".split(",");

        assertThat(str1).contains("1","2");
        assertThat(str2).contains("1");
    }

    @Test
    @DisplayName("substring() 학습 테스트")
    void subStringTest(){
        String str = "(1,2)".substring(1,4);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Exception 발생 시 예외처리 학습 테스트")
    void charAtTest(){
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
