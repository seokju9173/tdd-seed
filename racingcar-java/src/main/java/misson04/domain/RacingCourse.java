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

    public RacingCourse(int carCount) {
        this(IntStream.range(0, carCount)
                .mapToObj(i -> new RacingCar())
                .collect(Collectors.toList()));
    }

    public RacingCourse(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCourse(int carCount, List<String> names) {
        this.cars = createCars(names, carCount);
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars(RacingCarMovementStrategy racingCarMovementStrategy) {
        cars.forEach(car -> car.moveCar(racingCarMovementStrategy));
    }

    private List<RacingCar> createCars(List<String> names, int carCount) {
        List<RacingCar> cars = new ArrayList<>();
        IntStream.range(ZERO, carCount)
                .forEach(i -> cars.add(new RacingCar(names.get(i))));

        return cars;
    }
}
