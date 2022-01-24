package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car.Car;
import racingcar.Car.Cars;

import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("승자 검출 테스트")
    public void winnerTest() {
        //given
        Cars cars = new Cars("test1,test2,test3");

        //when
        // test1과 test3만 움직임
        cars.getCars().get(0).drivingCar(5);
        cars.getCars().get(1).drivingCar(3);
        cars.getCars().get(2).drivingCar(5);

        List<Car> winner = cars.getWinnerCars(1);

        //then
        Assertions.assertThat(winner.get(0).getCarName()).isEqualTo("test1");
        Assertions.assertThat(winner.get(1).getCarName()).isEqualTo("test3");
        // test2는 전진 못했으므로 우승자가 아니다.
    }
}
