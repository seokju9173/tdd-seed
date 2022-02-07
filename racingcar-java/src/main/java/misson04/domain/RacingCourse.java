package misson04.domain;

import misson04.utils.RacingCarMovementStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCourse {

    private final List<RacingCar> cars;

    private final static int ZERO = 0;

    // 객체 자신은 스스로 만들어야 한다. 외부로부터 만들면 안된다.
    public RacingCourse(List<String> names) {
        this.cars = createCars(names);
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars(RacingCarMovementStrategy racingCarMovementStrategy) {
        cars.forEach(car -> car.moveCar(racingCarMovementStrategy));
    }

    private List<RacingCar> createCars(List<String> names) {
        List<RacingCar> cars = new ArrayList<>();
        IntStream.range(ZERO, names.size())
                .forEach(i -> cars.add(new RacingCar(names.get(i))));

        return cars;
    }
}
