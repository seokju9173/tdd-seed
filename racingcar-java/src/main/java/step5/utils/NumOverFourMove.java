package step5.utils;

import java.util.Random;

public class NumOverFourMove implements CarMoveStrategy {
    private static final int MAX_BOUND = 10;
    private static final int RISE_POINT = 4;

    @Override
    public boolean move() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND) >= RISE_POINT;
    }
}
