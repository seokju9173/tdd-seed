package racingcar;

public class Position {

    private int distance;

    public Position() {
        this.distance = 1;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = 0; i < distance; i++)
            string += '-';
        return string;
    }

    public void increase() {
        distance++;
    }
}
