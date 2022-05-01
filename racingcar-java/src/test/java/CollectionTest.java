import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Collection 학습 테스트")
public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    @DisplayName("numbers Set 값 지정")
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers Set 사이즈 조회 학습 테스트")
    void setTest1() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest, ValueSource 어노테이션을 이용한 여러 케이스 테스트")
    void setTest2(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("ParameterizedTest, ValueSource 어노테이션을 이용한 여러 케이스 테스트")
    void setTest3(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}