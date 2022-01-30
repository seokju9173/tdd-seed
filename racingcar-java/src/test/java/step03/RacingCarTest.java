package step03;

import mission03.domain.RacingCar;
import mission03.domain.RacingCourse;
import mission03.utils.RacingCarMovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 생성되었을 때, 기본 값이 1인지 테스트")
    void initRacingCarTest() {
        final int DISTANCE_DEFAULT = 1;
        final RacingCar racingCar = new RacingCar();

        assertThat(racingCar.getMovedDistance()).isEqualTo(DISTANCE_DEFAULT);
    }

    @DisplayName("자동차가 이미 이동한 거리를 주입했을 때, 주입한 거리랑 같은지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 4"})
    void moveRacingCarCorrectTest(int initDistance, int resultDistance) {
        final RacingCar racingCar = new RacingCar(initDistance);

        assertThat(racingCar.getMovedDistance()).isEqualTo(resultDistance);
    }

    @Test
    @DisplayName("자동차들이 올바르게 움직이는지 테스트")
    void checkMovedRacingCarsCorrectTest() {
        // given
        final int MOVED_CARS_DISTANCE = 2;
        final RacingCarMovementStrategy racingCarMovementStrategy = () -> true;

        RacingCar racingCar01 = new RacingCar();
        RacingCar racingCar02 = new RacingCar();
        RacingCar racingCar03 = new RacingCar();

        List<RacingCar> cars = new ArrayList<>();
        cars.add(racingCar01);
        cars.add(racingCar02);
        cars.add(racingCar03);

        RacingCourse racingCourse = new RacingCourse(cars);

        // when
        racingCourse.moveCars(racingCarMovementStrategy);

        // then
        assertThat(cars.get(0).getMovedDistance()).isEqualTo(MOVED_CARS_DISTANCE);
        assertThat(cars.get(1).getMovedDistance()).isEqualTo(MOVED_CARS_DISTANCE);
        assertThat(cars.get(2).getMovedDistance()).isEqualTo(MOVED_CARS_DISTANCE);
    }
}
