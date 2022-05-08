package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("새로 생성한 위치 객체가 1인지 확인")
    void positionCreateTest() {
        Position position = new Position();
        assertThat(position.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("새로 생성한 위치 객체 문자열 확인")
    void positionStringTest() {
        Position position = new Position();
        assertThat(position.toString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 확인")
    void carCreateTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 객체 생성 후 위치 출력")
    void carStringTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 객체 생성 후 1칸 움직임")
    void carMoveTest() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(car.toString()).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차들 여러 대 생성 테스트")
    void carsCreateTest() {
        Cars cars2 = new Cars(2);
        assertThat(cars2.getCar(0).getPosition()).isEqualTo(1);
        assertThat(cars2.getCar(1).getPosition()).isEqualTo(1);
        assertThat(cars2.getCarList()).hasSize(2);
    }
}
