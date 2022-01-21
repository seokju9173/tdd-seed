package racingcar;

import java.util.Random;

public class Car {
    private static final int MAX_BOUND = 10;
    private static final String PROGRESS_STRING = "-";

    private static Random random = new Random();
    private String progress = "";

    void drivingCar () {
        if (random.nextInt(MAX_BOUND) > 3){
            this.progress += PROGRESS_STRING;
        }
    }

    public String getProgress() {
        return progress;
    }
}
