package step3.domain;

import java.util.Random;

public class Car {
    private final static int RANDOM_MAX_BOUND = 10;
    private final static int CAR_MOVE_POINT = 4;
    private final static int DEFAULT_DISTANCE = 1;
    private final static int INCREASE_DISTANCE_POINT = 1;
    private final static int MAX_CAR_NAME = 5;
    private final Random point = new Random();

    private final String carName;
    private int distance;

    public Car(String carName) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.carName = carName;
        this.distance = DEFAULT_DISTANCE;
    }

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void move() {
        if (point.nextInt(RANDOM_MAX_BOUND) >= CAR_MOVE_POINT) {
            distance += INCREASE_DISTANCE_POINT;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
