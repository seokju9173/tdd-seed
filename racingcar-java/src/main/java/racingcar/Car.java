package racingcar;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(int number) {
        this.position = new Position(number);
    }

    public int getPosition() {
        return position.getDistance();
    }

    public void move() {
        position.increase();
    }

    public String carString() {
        return position.positionString();
    }
}
