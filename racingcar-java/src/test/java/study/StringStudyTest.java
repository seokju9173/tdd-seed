package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 테스트")
public class StringStudyTest {

    @Test
    void 정수_1과_2를_콤마로_분리했을_때_잘_분리된다() {
        // given -> 조건
        final String numberString = "1,2";

        // when -> 실행
        final String[] numbers = numberString.split(",");

        // then -> 결과
        assertThat(numbers).containsExactly("1", "2");
    }
}
