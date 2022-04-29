import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringSplitTest {
    @Test
    void splitTest_1(){
        String[] str1 = "1,2".split(",");
        String[] str2 = "1".split(",");

        assertThat(str1).contains("1","2");
        assertThat(str2).contains("1");
    }
}
