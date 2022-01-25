package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열 테스트 : 주어진 문자열에 특정 값이 존재한다면 그것을 다른 문자로 변경할 수 있어야 한다.")
    void replace() {
        // Arrange
        var expect = "adc";
        var input = "abc";

        // Act
        var result = input.replace("b", "d");

        // Assert
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("문자열 테스트 : 주어진 문자열에 특정 값이 존재한다면 그것을 기준으로 잘라낼 수 있어야 한다.")
    void split_equals() {
        // Arrange
        var expect = new String[]{"1", "2"};
        var input = "1,2";

        // Act
        var result = input.split(",");

        // Assert
        assertArrayEquals(expect, result);
    }

    @Test
    @DisplayName("문자열 테스트 : 주어진 문자열에 특정 값이 존재하지 않는다면 잘라내져서는 안된다.")
    void split_non_equals() {
        // Arrange
        var expect = new String[]{"1"};
        var input = "1";

        // Act
        var result = input.split(",");

        // Assert
        assertArrayEquals(expect, result);
    }

    @Test
    @DisplayName("문자열 테스트 : 주어진 문자열에 소괄호가 존재한다면 제거하여야 한다.")
    void substring() {
        // Arrange
        var expect = "1,2";
        var input = "(1,2)";

        // Act
        var result = input.substring(1, input.length() - 1);

        // Assert
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("문자열 테스트 : 주어진 문자열 길이를 넘어가는 위치 값으로 접근한다면 IndexOutOfBoundsException 가 발생해야 한다")
    void char_at_failure() {
        // Arrange
        var input = "ab";
        var index = 2;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> input.charAt(index));
    }
}