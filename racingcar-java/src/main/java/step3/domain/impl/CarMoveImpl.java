package step3.domain.impl;

import step3.domain.Car;
import step3.domain.RandomNumber;
import step3.domain.RandomNumberImpl;

public class CarMoveImpl implements CarMove {

    private final static int RANDOM_MAX_BOUND = 10;
    private final static int INCREASE_DISTANCE = 1;

    private static RandomNumber random = new RandomNumberImpl();

    @Override
    public int move(Car car, String name) {
        if (car.getCarName().equals(name)) {
            return car.getDistance() + INCREASE_DISTANCE;
        }
        return car.getDistance();
    }

    @Override
    public int move(Car car, int targetBound) {
        if (random.createNumber(RANDOM_MAX_BOUND) >= targetBound) {
            return car.getDistance() + INCREASE_DISTANCE;
        }
        return car.getDistance();
    }
}
