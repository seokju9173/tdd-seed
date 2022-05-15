package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(MoveStrategy moveStrategy, int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("자동차가 없음");
        }
        cars = Collections.unmodifiableList(
                IntStream.rangeClosed(1, size)
                        .mapToObj(i -> new Car(moveStrategy))
                        .collect(Collectors.toList())
        );
    }

    public Cars(MoveStrategy moveStrategy, String string) {
        List<Name> names = NameSpliter.nameSplit(string);
        if(names.size() <= 0) {
            throw new IllegalArgumentException("자동차가 없음");
        }
        cars = Collections.unmodifiableList(
                IntStream.range(0, names.size())
                        .mapToObj(i -> new Car(moveStrategy, names.get(i)))
                        .collect(Collectors.toList())
        );
    }

    public void moveCars() {
        IntStream.range(0, cars.size())
                .forEach(i -> getCar(i).move());
    }

    public List<Car> getCarList() {
        return cars;
    }

    public Car getCar(int index) {
        validateCarsSize(index);
        return cars.get(index);
    }

    private void validateCarsSize(int index) {
        if(cars.size() < index + 1) {
            throw new IllegalArgumentException("carList size 보다 작은 index에 접근함");
        }
    }
}
