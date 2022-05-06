package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("새로 생성한 위치 객체가 1인지 확인")
    void positionCreateTest() {
        Position position = new Position();
        assertThat(position.getDistance()).isEqualTo(1);
    }

}
