package step3.domain;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber{
    public final static Random random = new Random();

    public int createNumber(final int bound){
        return random.nextInt(bound);
    }
}
