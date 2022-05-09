package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cars {

    final List<Car> carList = new ArrayList<>();

    public Cars(int size) {
        for(int i = 0; i < size; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public Car getCar(int index) {
        validateCarsSize(index);
        return carList.get(index);
    }

    public String[] getCarsStatus() {
        String[] strings = new String[carList.size()];
        for(int i = 0; i < strings.length; i++) {
            strings[i] = carList.get(i).toString();
        }
        return strings;
    }

    private void validateCarsSize(int index) {
        if(carList.size() < index + 1) {
            throw new IllegalArgumentException("carList size 보다 작은 index에 접근함");
        }
        if(carList.get(index) == null) {
            throw new IllegalArgumentException("carList의 null값에 접근함");
        }
    }
}
