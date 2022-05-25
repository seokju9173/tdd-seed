package racingcar5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NameSpliterTest {

    @Test
    @DisplayName("이름 분할 테스트")
    void nameSplitTest() {
        List<String> nameStrings = NameSpliter.nameSplit("pobi,crong,honux");
        assertAll(
                () -> assertThat(nameStrings.get(0)).isEqualTo("pobi"),
                () -> assertThat(nameStrings.get(2)).isEqualTo("honux"),
                () -> assertThat(nameStrings).hasSize(3)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 분할 실패 테스트")
    void nameSplitFailTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NameSpliter.nameSplit(name));
    }
}
