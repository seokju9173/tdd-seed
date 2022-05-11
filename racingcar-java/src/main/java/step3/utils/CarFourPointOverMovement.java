package step3.utils;

import java.util.Random;

public class CarFourPointOverMovement implements CarMovementStrategy {
    @Override
    public boolean move() {
        Random random = new Random();
        return random.nextInt(10) >= 5;
    }
}
