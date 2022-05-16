package racingcar;

public class Position {

    final static int START_POSITION = 1;

    private int distance;

    public Position(int distance) {
        this.distance = distance;
    }

    public Position() {
        this(START_POSITION);
    }

    public int getDistance() {
        return distance;
    }

    public void increase() {
        distance++;
    }
}
