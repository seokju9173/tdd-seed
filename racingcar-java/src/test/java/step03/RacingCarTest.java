package step03;

import mission03.domain.RacingCar;
import mission03.utils.RacingCarMovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 생성되었을 때, 기본 값이 1인지 테스트")
    void initRacingCarTest() {
        int DISTANCE_DEFAULT = 1;
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.getMovedDistance()).isEqualTo(DISTANCE_DEFAULT);
    }

    @DisplayName("자동차가 이미 이동한 거리를 주입했을 때, 주입한 거리랑 같은지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveRacingCarCorrectTest(int initDistance) {
        RacingCar racingCar = new RacingCar(initDistance);

        assertThat(racingCar.getMovedDistance()).isEqualTo(initDistance);
    }

    @Test
    @DisplayName("자동차들이 올바르게 움직이는지 테스트")
    void checkMovedRacingCarsCorrectTest() {
        // given
        int MOVED_CARS_DISTANCE = 2;
        RacingCarMovementStrategy racingCarMovementStrategy = () -> true;
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.moveCar(racingCarMovementStrategy);

        // then
        assertThat(racingCar.getMovedDistance()).isEqualTo(MOVED_CARS_DISTANCE);
    }

    @Test
    @DisplayName("자동차들이 움직이지 않도록 하는 테스트")
    void checkMovedRacingCarsNotMovingTest() {
        // given
        int DISTANCE_DEFAULT = 1;
        RacingCarMovementStrategy racingCarMovementStrategy = () -> false;
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.moveCar(racingCarMovementStrategy);

        // then
        assertThat(racingCar.getMovedDistance()).isEqualTo(DISTANCE_DEFAULT);
    }
}
