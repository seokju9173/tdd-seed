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
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }

    public void playOneRound() {
        for (Car c: cars) {
            c.move(getRandom());
        }
    }

    public List<Car> getWinners() {
        Car winner = getWinnerObject();
        return cars.stream()
                .filter(car -> car.getPosition() == winner.getPosition())
                .collect(Collectors.toList());
    }

    private Car getWinnerObject() {
        return cars.stream()
                .max(Comparator.comparing(Car :: getPosition))
                .orElseThrow(IllegalStateException::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandom() {
        return random.nextInt(10);
    }
}
