package racingcar;

public class Position {

    private int distance;

    public Position(int distance) {
        this.distance = distance;
    }

    public Position() {
        this(1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
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
