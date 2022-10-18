package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void splitExactly() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        str.substring(1, 4);
        assertThat(str).contains("1,2");
    }
}
