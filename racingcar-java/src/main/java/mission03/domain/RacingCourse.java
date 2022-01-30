package mission03.domain;

import mission03.utils.RacingCarMovementStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCourse {

    private List<RacingCar> cars;

    // 객체 자신은 스스로 만들어야 한다. 외부로부터 만들면 안된다.
    public RacingCourse(int carCount) {
        this(IntStream.range(0, carCount)
                .mapToObj(i -> new RacingCar())
                .collect(Collectors.toList()));
    }

    public RacingCourse(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public void moveCars(RacingCarMovementStrategy racingCarMovementStrategy) {
        cars.forEach(car -> car.moveCar(racingCarMovementStrategy));
    }
}
