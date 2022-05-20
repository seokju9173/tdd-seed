package racingcar5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

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
