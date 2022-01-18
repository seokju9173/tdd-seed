package misson01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항01 - size()함수를 통한 SET 사이즈 확인")
    void Set의_내장함수_size를_활용해_Set의_크기를_확인한다(){
        // when
        final int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest // 중복을 효과적으로 나태내준다. 또한 @Test 써줄 필요 X
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항02 - contains()함수를 통한 기존의 정수값 존재 확인 ")
    void contain메소드를_활용해_미리_저장된_값이_존재하는지_확인한다(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true","2, true","3, true", "4, false", "5, false"})
    @DisplayName("요구사항03 - contain()함수를 통해 다른 정수값 확인")
    void contain메소드를_활용해_미리_저장된_값이_존재하는지_확인한다(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
