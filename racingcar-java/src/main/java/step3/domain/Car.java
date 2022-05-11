package step3.domain;


import step3.domain.impl.CarMove;
import step3.domain.impl.CarMoveImpl;

public class Car {
    private final static int CAR_MOVE_POINT = 4;
    private final static int DEFAULT_DISTANCE = 1;
    private final static int MAX_CAR_NAME = 5;
    private final static String MOVE_CAR_NAME = "pobi";

    private CarMove carMove;

    private final String carName;
    private int distance;


    public Car(final String carName, final int distance, final CarMove carMove) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.carName = carName;
        this.distance = distance;
        this.carMove = carMove;
    }

    public Car(final String carName) {
        this(carName, DEFAULT_DISTANCE, new CarMoveImpl());
    }

    public Car(final String carName, final CarMove carMove) {
        this(carName, DEFAULT_DISTANCE, carMove);
    }

    public void move() {
        distance = carMove.move(this, CAR_MOVE_POINT);
        //distance = carMove.move(this, MOVE_CAR_NAME);
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public String winnerCarName(int max) {
        if (this.distance == max) {
            return this.carName;
        }
        return "";
    }
}
