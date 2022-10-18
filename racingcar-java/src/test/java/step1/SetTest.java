package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 확인")
    void sizeTest() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("1,2,3의 값이 존재하는지 확인하는 코드의 중복 코드 제거")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
