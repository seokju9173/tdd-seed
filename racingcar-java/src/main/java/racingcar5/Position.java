package racingcar5;

public class Position {

    private int distance;

    public Position(int distance) {
        this.distance = distance;
    }

    public Position() {
        this(1);
    }

    public void increase() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
