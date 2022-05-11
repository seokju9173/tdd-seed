package step3.domain;


import step3.utils.CarMovementStrategy;
import step3.utils.CarFourPointOverMovement;

import java.awt.*;

public class Car {
    private final static int DEFAULT_DISTANCE = 1;
    private final static int MAX_CAR_NAME = 5;

    private final CarMovementStrategy carMovementStrategy;

    private final String carName;
    private final Distance distance;


    public Car(final String carName, final Distance distance, final CarMovementStrategy carMovementStrategy) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.carName = carName;
        this.distance = distance;
        this.carMovementStrategy = carMovementStrategy;
    }

    public Car(final String carName) {
        this(carName, new Distance(DEFAULT_DISTANCE), new CarFourPointOverMovement());
    }

    public Car(final String carName, final CarMovementStrategy carMovementStrategy) {
        this(carName, new Distance(DEFAULT_DISTANCE), carMovementStrategy);
    }

    public Car move() {
        if (carMovementStrategy.move()) {
            return new Car(carName, distance.increase(), carMovementStrategy);
        }
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String winnerCarName(int max) {

        return "";
    }
}
