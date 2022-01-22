package domain;

public class Car {

    private static final int CONDITION_MOVE = 4;

    private static final int DEFAULT_POSITION = 0;

    private int position = DEFAULT_POSITION;

    public void move(int randomInt) {
        if (randomInt < 0 || randomInt >= 10) {
            throw new IllegalArgumentException("0에서 9사이의 숫자여야 합니다");
        }
        if (randomInt >= CONDITION_MOVE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
