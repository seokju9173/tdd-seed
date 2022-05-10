package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars{
    private final List<Car> cars;

    public Cars(final String carName) {
        String[] splitCarNames = carName.split(",");
        cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        cars.stream()
                .peek(Car::move)
                .collect(Collectors.toList());
    }

    public List<Car> winner(){
        int max = maxCarPoint();

        return cars.stream()
                .filter(car -> max == car.getDistance())
                .collect(Collectors.toList());
    }

    private int maxCarPoint(){
        Car car = cars
                .stream()
                .max(Comparator.comparing(Car::getCarName))
                .orElse(new Car("test",0));

        return car.getDistance();
    }

}
