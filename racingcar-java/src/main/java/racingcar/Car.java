package racingcar;

import java.util.Random;

public class Car {
    private static final int MAX_BOUND = 10;
    private static final int ALLOW_DRIVE = 4;
    private static final int START_LINE = 0;
    private static final int DRIVE_CAR_AT_ONE_CYCLE = 1;

    private static final Random random = new Random();
    private int progress = START_LINE;

    void drivingCar () {
        if (random.nextInt(MAX_BOUND) >= ALLOW_DRIVE){
            this.progress += DRIVE_CAR_AT_ONE_CYCLE;
        }
    }

    public int getProgress() {
        return progress;
    }
}
