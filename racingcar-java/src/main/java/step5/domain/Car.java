package step5.domain;

public class Car {
    private final String carName;
    private final Distance distance;

    public Car(final String carName, final Distance distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public Car(final String carName, final int distance) {
        this(carName, new Distance(distance));
    }

    public Car move(){
        return new Car(carName, distance.increase());
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getCarName() {
        return carName;
    }
}
