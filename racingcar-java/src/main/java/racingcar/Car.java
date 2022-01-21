package racingcar;

import java.util.Random;

public class Car {
    private static Random random = new Random();
    private String progress = "";

    void drivingCar () {
        if (random.nextInt(10) > 3){
            this.progress += "-";
        }
    }

    public String getProgress() {
        return progress;
    }
}
