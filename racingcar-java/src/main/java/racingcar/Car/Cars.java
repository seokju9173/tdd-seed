package racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final Random random = new Random();
    private static final int MAX_BOUND = 10;

    private List<Car> cars;

    public Cars(int carsTotal) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carsTotal; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.drivingCar(random.nextInt(MAX_BOUND));
        }
    }
}
