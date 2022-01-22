package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final List<Car> cars;

    private static final int MIN_NUMBER_CARS = 2;

    private Random random = new Random();

    public RacingCar(int numberCars) {
        this.cars = setCars(numberCars);
    }

    private List<Car> setCars(int numberCar) {
        checkValidNumberCars(numberCar);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void checkValidNumberCars(int numberCar) {
        if (numberCar < MIN_NUMBER_CARS) {
            throw new IllegalArgumentException("2 이상의 값을 입력해주세요");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandom() {
        return random.nextInt(10);
    }

    public void playOneRound() {
        for (Car c: cars) {
            c.move(getRandom());
        }
    }
}
