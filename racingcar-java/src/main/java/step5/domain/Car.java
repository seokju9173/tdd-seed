package step5.domain;

import step5.utils.CarMoveStrategy;

public class Car {
    private final String carName;
    private final Distance distance;
    private final CarMoveStrategy carMoveStrategy;

    public Car(final String carName, final Distance distance, final CarMoveStrategy carMoveStrategy) {
        this.carName = carName;
        this.distance = distance;
        this.carMoveStrategy = carMoveStrategy;
    }

    public Car(final String carName, final int distance, final CarMoveStrategy carMoveStrategy) {
        this(carName, new Distance(distance), carMoveStrategy);
    }

    public Car move(){
        if(carMoveStrategy.move()){
            return new Car(carName, distance.increase(), carMoveStrategy);
        }
        return this;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getCarName() {
        return carName;
    }
}
