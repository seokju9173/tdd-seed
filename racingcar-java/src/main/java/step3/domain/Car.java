package step3.domain;

import java.util.Random;

public class Car {
    private final static int RANDOM_MAX_BOUND = 10;
    private final static int CAR_MOVE_POINT = 4;

    int number;
    String distance;

    public Car(int number) {
        this.number = number;
        this.distance = "-";
        printDistance();
    }

    public void printDistance() {
        System.out.println(distance);
    }

    public void move() {
        Random point = new Random();
        if (point.nextInt(RANDOM_MAX_BOUND) >= CAR_MOVE_POINT) {
            distance += "-";
        }
    }
}
