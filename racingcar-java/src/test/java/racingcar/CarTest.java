package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car.Car;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    public void moveTest() throws Exception {
        // given
        Car move = new Car();
        Car stop = new Car();

        // when
        move.drivingCar(4);
        stop.drivingCar(3);

        // then
        Assertions.assertThat(move.getPosition()).isEqualTo(1);
        Assertions.assertThat(stop.getPosition()).isEqualTo(0);
    }
}
