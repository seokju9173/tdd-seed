package step5.domain;

public class Distance {
    private static final int INCREASE_CAR_DISTANCE = 1;

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance increase(){
        return new Distance(distance + INCREASE_CAR_DISTANCE);
    }

    public int getDistance() {
        return distance;
    }
}
