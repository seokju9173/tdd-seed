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

    public String positionString() {
        String string = "";
        char character = ResultView.getPrintCharacter();
        for(int i = 0; i < distance; i++)
            string += character;
        return string;
    }

    public void increase() {
        distance++;
    }
}
