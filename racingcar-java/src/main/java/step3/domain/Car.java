package step3.domain;

import java.util.Random;

public class Car {
    private final static int RANDOM_MAX_BOUND = 10;
    private final static int CAR_MOVE_POINT = 4;
    private final Random point = new Random();

    private int number;
    private int distance;

    public Car(int number) {
        this.number = number;
        this.distance = 1;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (point.nextInt(RANDOM_MAX_BOUND) >= CAR_MOVE_POINT) {
            distance += 1;
        }
    }
}
