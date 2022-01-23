package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car.Car;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    public void moveTest() {
        // given
        Car move = new Car("moveCar");

        // when
        move.drivingCar(4);

        // then
        Assertions.assertThat(move.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정차 테스트")
    public void stopTest() {
        // given
        Car stop = new Car("stopCar");

        // when
        stop.drivingCar(3);

        // then
        Assertions.assertThat(stop.getPosition()).isEqualTo(0);
    }
}
