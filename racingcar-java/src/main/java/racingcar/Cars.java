package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int size) {
        for(int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        if(size <= 0)
            cars.add(new Car());
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public Car getCar(int index) {
        validateCarsSize(index);
        return cars.get(index);
    }

    public List<String> getCarsStatus() {
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++) {
            strings.add(cars.get(i).carString());
        }
        return strings;
    }

    private void validateCarsSize(int index) {
        if(cars.size() < index + 1) {
            throw new IllegalArgumentException("carList size 보다 작은 index에 접근함");
        }
    }
}
