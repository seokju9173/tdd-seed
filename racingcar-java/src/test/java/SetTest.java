import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

final class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    public final void setSiseTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest  //dependencies: 'org.junit.jupiter:junit-jupiter-params:5.4.2'
    @ValueSource(ints = {1, 2, 3})
    public final void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public final void containsVarietyTest(String input, String expected) {
        Assertions.assertEquals(Boolean.toString(numbers.contains(Integer.parseInt(input))), expected);
    }
}