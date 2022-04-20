package misson04.utils;

import java.util.Random;

public class RacingCarRandomMovement implements RacingCarMovementStrategy {

    private static final int RANDOM_SIZE = 10;
    private static final int FOUR = 4;

    private final Random randomBox = new Random();

    @Override
    public boolean makeRandomMovement() {
        return randomBox.nextInt(RANDOM_SIZE) >= FOUR;
    }
}
