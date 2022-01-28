package step03;

import mission03.domain.RacingCar;
import mission03.domain.RacingCourse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCourseTest {

    private static final int INIT_RACING_CAR_DISTANCE = 1;
    private static final int RANDOM_START_INDEX = 0;
    private static final int RANDOM_END_INDEX = 9;

    @Test
    void test() {
        int a = 5;
        RacingCourse racingCourse = new RacingCourse(a);

        RacingCar racingCar1 = new RacingCar();

        RacingCar racingCar2 = new RacingCar(2);

        RacingCar racingCar3 = new RacingCar(3);

        List<RacingCar> lst = new ArrayList<>();
        lst.add(racingCar1);
        lst.add(racingCar2);
        lst.add(racingCar3);
        lst.forEach(car -> car.moveCar(() -> true));

    }
}

    // 함수형 인터페이스 편하게
//
//        RacingCar racingCar01 = new RacingCar();
//        RacingCar racingCar02 = new RacingCar();

//    private RacingCourse racingCourse;
//
//    @BeforeEach
//    void init() {
//        racingCourse = new RacingCourse();
//    }
//
//    @DisplayName("자동차 개수를 받으면, 알맞은 자동차 개수를 받았는지 테스트")
//    @CsvSource({"1, 1", "2, 2", "3, 3", "4, 4"})
//    @ParameterizedTest
//    void initRacingCarCountTest(int input, int output) {
//        // when
//        racingCourse.initRacingCars(input);
//
//        // then
//        assertThat(racingCourse.getCars()).hasSize(output);
//        racingCourse.getCars().forEach(car -> {
//            assertThat(car.getMovedDistance()).isEqualTo(INIT_RACING_CAR_DISTANCE);
//        });
//    }
//
//    @DisplayName("레이싱 경주장에 있는 자동차들이 랜덤을 통해 자동차를 움직일 때, 수치가 허용치인지 테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
//    public void checkAllRacingCarTakeRandomMovement(int input) {
//        // given
//        racingCourse.initRacingCars(input);
//
//        // when
//        IntStream.range(RANDOM_START_INDEX, RANDOM_END_INDEX - INIT_RACING_CAR_DISTANCE)
//                .forEach(i -> racingCourse.moveCars());
//
//        racingCourse.getCars()
//                .forEach(car -> assertThat(car.getMovedDistance())
//                        .isBetween(RANDOM_START_INDEX, RANDOM_END_INDEX));
//    }
/**
 * 1. 자동차 개수 받으면, 크기에 맞춰 자동차 생성
 * 2. 레이싱 경주에서 자동차들이 움직인 횟수가 정상 범위 안에 있는지
 * 이정도가 최대인 것 같아요. step 넘어가면, 추가적인 테스트 코드 작성
 */
