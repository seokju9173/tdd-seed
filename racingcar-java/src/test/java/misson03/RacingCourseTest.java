package misson03;

import misson04.domain.RacingCar;
import misson04.domain.RacingCourse;
import misson04.utils.RacingCarMovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCourseTest {

    @DisplayName("입력받은 숫자만큼 자동차를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void initInputSizeIsRacingCarSize(int initCarsSize) {
        RacingCourse racingCourse = new RacingCourse(initCarsSize);
        List<RacingCar> cars = racingCourse.getCars();

        assertThat(cars).hasSize(initCarsSize);
    }

    @DisplayName("임의로 준 이미 이동한 거리를 가진 자동차가 올바르게 이동하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "2, 3, 4", "3, 4, 5"})
    void checkAnotherMovedCarsAreMoving(int firstRacingCar, int secondRacingCar, int thirdRacingCar) {
        // given
        int DISTANCE_DEFAULT = 1;
        RacingCarMovementStrategy racingCarMovementStrategy = () -> true;
        RacingCar racingCar1 = new RacingCar(firstRacingCar);
        RacingCar racingCar2 = new RacingCar(secondRacingCar);
        RacingCar racingCar3 = new RacingCar(thirdRacingCar);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(racingCar1);
        cars.add(racingCar2);
        cars.add(racingCar3);

        // when
        RacingCourse racingCourse = new RacingCourse(cars);
        racingCourse.moveCars(racingCarMovementStrategy);

        // then
        assertThat(racingCar1.getMovedDistance()).isEqualTo(firstRacingCar + DISTANCE_DEFAULT);
        assertThat(racingCar2.getMovedDistance()).isEqualTo(secondRacingCar + DISTANCE_DEFAULT);
        assertThat(racingCar3.getMovedDistance()).isEqualTo(thirdRacingCar + DISTANCE_DEFAULT);
    }
}

