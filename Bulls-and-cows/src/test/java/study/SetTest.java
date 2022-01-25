package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    @Test
    @DisplayName("셋 테스트 : 셋에 중복된 데이터가 저장될 경우 중복된 값은 제거되어야 한다.")
    void size() {
        // Arrange
        var numbers = new HashSet<Integer>(List.of(1, 1, 2, 3));
        var expect = 3;

        // Act
        int result = numbers.size();

        // Assert
        assertEquals(expect, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("셋 테스트 : 셋에 저장된 데이터를 조회할 경우 True 를 반환해야 한다.")
    void contains(int input) {
        // Arrange
        var numbers = new HashSet<>(List.of(1, 2, 3));

        // Act
        boolean result = numbers.contains(input);

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4"})
    @DisplayName("셋 테스트 : 셋에 저장되지 않은 데이터를 조회할 경우 False 를 반환해야 한다.")
    void contains_failure(int arg1, int arg2, int arg3, int input) {
        // Arrange
        var numbers = new HashSet<>(List.of(arg1, arg2, arg3));

        // Act
        boolean result = numbers.contains(input);

        // Assert
        assertFalse(result);
    }
}
