public class Car {

    private static final int CONDITION_MOVE = 4;

    private int position = 0;

    void move(int randomInt) {
        if (randomInt >= CONDITION_MOVE) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }

}
