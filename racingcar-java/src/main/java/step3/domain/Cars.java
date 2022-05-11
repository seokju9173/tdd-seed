package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다");
        }
        String[] splitCarNames = carName.split(",");
        cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars move() {
        return new Cars(cars.stream()
                .map(Car::move)
                .collect(Collectors.toList()));
    }

    public List<String> winner() {
        int max = maxCarPoint();

        return cars.stream()
                .map(car -> car.winnerCarName(max))
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

    private int maxCarPoint() {
        Car car = cars
                .stream()
                .max(Comparator.comparing(Car::getDistance))
                .orElseThrow(() -> new IllegalArgumentException("우승자가 없습니다"));

        return car.getDistance();
    }

}
