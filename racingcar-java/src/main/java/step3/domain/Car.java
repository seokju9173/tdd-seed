package step3.domain;


public class Car {
    private final static int RANDOM_MAX_BOUND = 10;
    private final static int CAR_MOVE_POINT = 4;
    private final static int DEFAULT_DISTANCE = 1;
    private final static int INCREASE_DISTANCE_POINT = 1;
    private final static int MAX_CAR_NAME = 5;

    private final String carName;
    private int distance;
    private RandomNumber random;


    public Car(String carName, int distance, RandomNumber random) {
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.carName = carName;
        this.distance = distance;
        this.random = random;
    }

    public Car(String carName) {
        this(carName, DEFAULT_DISTANCE, new RandomNumber());
    }

    public void move() {
        if (random.createNumber(RANDOM_MAX_BOUND) >= CAR_MOVE_POINT) {
            distance += INCREASE_DISTANCE_POINT;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public String winnerCarName(int max){
        if(this.distance == max){
            return this.carName;
        }
        return "";
    }
}
