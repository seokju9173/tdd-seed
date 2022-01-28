//package step03;
//
//import mission03.domain.RacingCar;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RacingCarTest {
//
//    private static final int MOVED_RACING_CAR_DISTANCE = 1;
//
//    private RacingCar racingCar;
//
//    @BeforeEach
//    void init() {
//        racingCar = new RacingCar();
//    }
//
//    @Test
//    @DisplayName("자동차가 생성되었을 때, 기본 값이 1인지 테스트")
//    void initRacingCarTest() {
//        assertThat(racingCar.getMovedDistance()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("자동차가 올바르게 움직이는지 테스트")
//    void moveRacingCarCorrectTest() {
//        // given
//        final int initDistance = racingCar.getMovedDistance();
//
//        // when
//        racingCar.moveCar();
//
//        // then
//        assertThat(racingCar.getMovedDistance()).isEqualTo(initDistance + MOVED_RACING_CAR_DISTANCE);
//    }
//
///**
// * 1. 자동차가 움직이는지 테스트
// * 2. 자동차를 생성했을 때, 초기 값이 1인지 테스트하기
// * 이정도가 최대인 것 같아요. step 넘어가면, 추가적인 테스트 코드 작성
// */
//}
