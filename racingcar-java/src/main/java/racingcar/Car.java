package racingcar;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public int getPosition() {
        return position.getDistance();
    }

    public void move() {
        this.position.increase();
    }

    public String carString() {
        return position.positionString();
    }
}
