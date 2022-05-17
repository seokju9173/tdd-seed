package step5.domain;

import step5.utils.CarMoveStrategy;
import step5.utils.NumOverFourMove;

public class Car {
    private static final int DEFAULT_DISTANCE = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String MAX_CAR_NAME_LENGTH_OVER_COMMENT = "자동차의 이름은 5글자를 넘을 수 없습니다. : ";

    private final String carName;
    private final Distance distance;
    private final CarMoveStrategy carMoveStrategy;

    public Car(final String carName, final Distance distance, final CarMoveStrategy carMoveStrategy) {
        checkCarNameLength(carName);
        this.carName = carName;
        this.distance = distance;
        this.carMoveStrategy = carMoveStrategy;
    }

    public Car(final String carName, final int distance, final CarMoveStrategy carMoveStrategy) {
        this(carName, new Distance(distance), carMoveStrategy);
    }

    public Car(final String carName) {
        this(carName, new Distance(DEFAULT_DISTANCE), new NumOverFourMove());
    }

    public Car move() {
        if (carMoveStrategy.move()) {
            return new Car(carName, distance.increase(), carMoveStrategy);
        }
        return this;
    }

    public boolean winner(final int max) {
        return distance.getDistance() == max;
    }

    private void checkCarNameLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_CAR_NAME_LENGTH_OVER_COMMENT + carName);
        }
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getCarName() {
        return carName;
    }
}
