package mission03.domain;

import java.util.Random;

public class RacingCarMovement {

    private static final int RANDOM_SIZE = 10;
    private static final int FOUR = 4;

    public boolean makeRandomMovement() {
        final Random RandomBox = new Random();
        return RandomBox.nextInt(RANDOM_SIZE) >= FOUR;
    }
}
