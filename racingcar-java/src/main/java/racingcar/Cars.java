package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    final static List<Car> carList = new ArrayList<>();

    public Cars(int size) {
        for(int i = 0; i < size; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public Car getCar(int index) {
        return carList.get(index);
    }
}
