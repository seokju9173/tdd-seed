import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberStringsTest {

    // 실패 테스트 케이스
    @Test
    void 정수_1과_2를_콤마로_분리했을_때_잘_분리된다() {
        final NumberStrings numberStrings = new NumberStrings("2,3");

        final List<String> numberStrings2 = numberStrings.split(",");

        assertThat(numberStrings2).containsExactly("2", "3");
    }
}