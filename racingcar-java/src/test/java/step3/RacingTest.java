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

    @Test
    @DisplayName("Cars에 Car넣고 경주 테스트")
    void carRacingTest(){
        Map<Integer, Cars> round = new HashMap<>();
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("pobi", new Distance(1), () -> true),
                        new Car("nabi", new Distance(3), () -> true),
                        new Car("tobi", new Distance(2), () -> true)
                )
        );

        round.put(1, new Cars(cars.getCars().stream()
                .map(Car::move)
                .collect(Collectors.toList())));

        assertAll(
                () -> assertThat( round.get(1).getCars().get(0).getDistance() ).isEqualTo(2),
                () -> assertThat( round.get(1).getCars().get(1).getDistance() ).isEqualTo(4),
                () -> assertThat( round.get(1).getCars().get(2).getDistance() ).isEqualTo(3)
        );
    }
}