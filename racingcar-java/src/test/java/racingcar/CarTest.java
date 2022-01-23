package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car.Car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    public void moveTest() {
        // given
        Car move = new Car("move");

        // when
        move.drivingCar(4);

        // then
        Assertions.assertThat(move.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정차 테스트")
    public void stopTest() {
        // given
        Car stop = new Car("stop");

        // when
        stop.drivingCar(3);

        // then
        Assertions.assertThat(stop.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름 5자 넘길 때")
    public void longNameTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Car("LoooooooongName")
                ).withMessageMatching("차량의 이름은 5자를 넘길 수 없습니다.");
    }
}
