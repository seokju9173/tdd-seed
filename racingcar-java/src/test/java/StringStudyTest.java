import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringStudyTest {

  @DisplayName("1,2을 ,로 split() 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
  @Test
  void split1Test() {
    String input = "1,2";
    String[] split = input.split(",");
    String one = split[0];
    String two = split[1];

    assertAll(
        () -> assertEquals(one, "1"),
        () -> assertEquals(two, "2")
    );
  }

  @DisplayName("1을 ,로 split() 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현")
  @Test
  void split2Test() {
    String input = "1";
    String[] split = input.split(",");
    String one = split[0];
    assertEquals(one, "1");
  }

  @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
  @Test
  void substringTest() {
    String input = "(1,2)";
    String substring = input.substring(1, input.length() - 1);
    assertEquals(substring, "1,2");
  }

  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현")
  @Test
  void chatAtTest() {
    String input = "abc";
    char a = input.charAt(0);
    int outBoundPosition = 4;

    assertAll(
        () -> assertNotNull(a),
        () -> assertThrows(StringIndexOutOfBoundsException.class, () -> {
          input.charAt(outBoundPosition);
        })
    );
  }
}
