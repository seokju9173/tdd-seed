package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(int size) {
        List<Car> temp = new ArrayList<>();
        IntStream.rangeClosed(1, size).
                mapToObj(i -> new Car()).
                forEach(temp::add);
        if(size <= 0)
            temp.add(new Car());
        cars = Collections.unmodifiableList(temp);
    }

    public List<Car> getCarList() {
        return cars;
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
