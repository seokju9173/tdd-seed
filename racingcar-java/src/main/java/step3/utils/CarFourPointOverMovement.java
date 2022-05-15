package step3.utils;

import java.util.Random;

public class CarFourPointOverMovement implements CarMovementStrategy {
    private static final int MAX_BOUND = 10;
    private static final int TARGET_POINT = 4;

    @Override
    public boolean move() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND) >= TARGET_POINT;
    }
}
