package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.utils.NumOverFourMove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("domain 테스트")
public class CarTest {

    @Test
    @DisplayName("Car 객체에 이름과 거리를 포함한 객체 생성 테스트")
    void createCarObjectTest() {
        Car car = new Car("pobi", 1, new NumOverFourMove());

        String name = car.getCarName();
        int distance = car.getDistance();

        assertAll(
                () -> assertThat(name).isEqualTo("pobi"),
                () -> assertThat(distance).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Car 객체의 이동 이벤트 테스트")
    void carMoveTest(){
        Car car = new Car("pobi", 1, () -> true);

        car = car.move();

        assertThat(car.getDistance()).isEqualTo(2);
    }
}
