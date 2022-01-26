package domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {

    private final List<Car> cars;

    private Random random = new Random();

    public RacingCar(String inputNames) {
        this.cars = setCars(inputNames);
    }

    private List<Car> setCars(String inputNames) {
        String[] carNames = inputNames.split(",");

        List<Car> cars = new ArrayList<>();
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void playOneRound() {
        for (Car c: cars) {
            c.move(getRandom());
        }
    }

    public List<Car> getWinners() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> isSameCar(winner, car))
                .collect(Collectors.toList());
    }

    private boolean isSameCar(Car winner, Car car) {
        return car.position == winner.position;
    }

    private Car getWinner() {
        return cars.stream()
                .max(Comparator.comparing(Car :: getPosition))
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandom() {
        return random.nextInt(10);
    }
}
