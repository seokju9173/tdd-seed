package racingcar;

import java.util.Random;

public class MoveStrategyRandom implements MoveStrategy {

    private final static int FORWARD_BOUND = 4;

    @Override
    public boolean isMove() {
        Random random = new Random();
        int number = random.nextInt(10);
        if(number >= FORWARD_BOUND)
            return true;
        return false;
    }
}
