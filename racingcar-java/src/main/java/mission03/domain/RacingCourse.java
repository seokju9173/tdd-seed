package mission03.domain;

import mission03.utils.RacingCarMovementStrategy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCourse {

    private static final int INIT_RACING_CAR_DISTANCE = 1;

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

    public void moveCars(int tryCount, RacingCarMovementStrategy racingCarMovementStrategy) {
        IntStream.range(INIT_RACING_CAR_DISTANCE, tryCount)
                .forEach(i -> cars.forEach(car -> car.moveCar(racingCarMovementStrategy)));
    }
}
