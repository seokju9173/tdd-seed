package racingcar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        String character = ResultView.getPrintCharacter();
        return IntStream.rangeClosed(1, distance).
                filter(i -> i == distance).
                mapToObj(i -> character.repeat(i)).
                collect(Collectors.joining());
    }

    public void increase() {
        distance++;
    }
}
