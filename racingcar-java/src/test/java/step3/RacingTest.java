package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Distance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("레이싱 테스트")
class RacingTest {

    @Test
    @DisplayName("Car의 distance 증가 확인")
    void carDistanceIncreaseTest(){
        Car car = new Car("pobi", new Distance(1), () -> true);

        car = car.move();

        assertThat(car.getDistance()).isEqualTo(2);
    }

}