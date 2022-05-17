package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(String carNames) {
        String[] str = carNames.split(",");
        cars = Arrays.stream(str)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars move() {
        return new Cars(cars.stream()
                .map(Car::move)
                .collect(Collectors.toList()));
    }

    public List<String> winner() {
        int max = max();
        return cars.stream()
                .filter(car -> car.winner(max))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int max() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("승자가 존재하지 않습니다."));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
