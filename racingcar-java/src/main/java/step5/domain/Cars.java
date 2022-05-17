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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
