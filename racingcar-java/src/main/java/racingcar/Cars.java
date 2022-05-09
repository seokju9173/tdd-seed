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
        Optional<Car> optionalCar = Optional.ofNullable(carList.get(index));
        if(optionalCar.isPresent())
            return optionalCar.get();
        throw new IllegalArgumentException("carList에서 null이 반환됨");
    }

    public String[] getCarsStatus() {
        String[] strings = new String[carList.size()];
        for(int i = 0; i < strings.length; i++)
            strings[i] = carList.get(i).toString();
        return strings;
    }

    public void printCarsStatus() {
        String[] carsStatus = getCarsStatus();
        for(int i = 0; i < carsStatus.length; i++) {
            System.out.println(carsStatus[i]);
        }
    }
}
