package step3.domain;

public class Distance {
    private static final int INCREASE_DISTANCE_POINT = 1;

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance increase() {
        return new Distance(distance + INCREASE_DISTANCE_POINT);
    }

    public int getDistance() {
        return distance;
    }
}
