package step03;

import mission03.domain.RacingCar;
import mission03.domain.RacingCourse;
import mission03.utils.RacingCarMovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCourseTest {

    private static final int INIT_RACING_CAR_DISTANCE = 1;
    private static final int RANDOM_START_INDEX = 0;
    private static final int RANDOM_END_INDEX = 9;

    @DisplayName("입력받은 숫자만큼 자동차를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void initInputSizeIsRacingCarSize(int initCarsSize) {
        final RacingCourse racingCourse = new RacingCourse(initCarsSize);
        final List<RacingCar> cars = racingCourse.getCars();

        assertThat(cars).hasSize(initCarsSize);
    }

    @DisplayName("이동한 거리가 다른 자동차들이 전략에 맞춰 자동차가 올바르게 이동하는지 테스트")
    @Test
    void checkAnotherMovedCarsAreMoving() {
        // given
        final RacingCarMovementStrategy racingCarMovementStrategy = () -> true;
        RacingCar racingCar00 = new RacingCar(1);
        RacingCar racingCar01 = new RacingCar(2);
        RacingCar racingCar02 = new RacingCar(3);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(racingCar00);
        cars.add(racingCar01);
        cars.add(racingCar02);

        // when
        final RacingCourse racingCourse = new RacingCourse(cars);
        racingCourse.moveCars(racingCarMovementStrategy);

        // then
        assertThat(cars.get(00).getMovedDistance()).isEqualTo(2);
        assertThat(cars.get(01).getMovedDistance()).isEqualTo(3);
        assertThat(cars.get(02).getMovedDistance()).isEqualTo(4);
    }
}

