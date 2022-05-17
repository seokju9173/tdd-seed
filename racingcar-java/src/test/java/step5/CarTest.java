package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Test
public class CarTest {

    @Test
    @DisplayName("Car 객체에 이름과 거리를 포함한 객체 생성 테스트")
    void createCarObjectTest() {
        Car car = new Car("pobi", 1);

        String name = car.getName();
        int distance = car.getDistance;

        assertAll(
                () -> assertThat(name).isEqualTo("pobi"),
                () -> assertThat(distance).isEqualTo(1)
        );
    }
}
