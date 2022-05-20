package racingcar5;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    private final static int FORWARD_BOUND = 4;

    @Override
    public boolean isMove() {
        Random random = new Random();
        return random.nextInt(10) >= FORWARD_BOUND;
    }
}
