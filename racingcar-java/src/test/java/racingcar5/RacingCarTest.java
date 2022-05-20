package racingcar5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("위치 객체 테스트")
    void positionCreateTest() {
        Position position1 = new Position();
        Position position2 = new Position(2);
        Position position3 = new Position(3);
        position3.increase();
        assertAll(
                () -> assertThat(position1.getDistance()).isEqualTo(1),
                () -> assertThat(position2.getDistance()).isEqualTo(2),
                () -> assertThat(position3.getDistance()).isEqualTo(4)
        );
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void carCreateTest() {
        Car car = new Car("pobi");
        assertAll(
                () -> assertThat(car.getName()).isEqualTo("pobi"),
                () -> assertThat(car.getPosition()).isEqualTo(1)
        );
    }
}
