package racingcar5;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final static int FORWARD_BOUND = 4;
    private final static int RANDOM_MAX = 10;

    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX) >= FORWARD_BOUND;
    }
}
