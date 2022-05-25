package racingcar5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;

    public Cars(MoveStrategy moveStrategy, String names) {
        List<String> carNames = NameSpliter.nameSplit(names);
        cars = IntStream.range(0, carNames.size())
                .mapToObj(i -> new Car(moveStrategy, carNames.get(i)))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        IntStream.range(0, cars.size())
                .forEach(i -> cars.get(i).move());
    }

    public Car getCar(int index) {
        validateIndex(index);
        return cars.get(index);
    }

    public int getSize() {
        return cars.size();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= cars.size()) {
            throw new IllegalArgumentException("잘못된 인덱스 접근");
        }
    }
}
