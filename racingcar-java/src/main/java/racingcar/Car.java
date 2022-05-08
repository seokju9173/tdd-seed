package racingcar;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public int getPosition() {
        return position.getDistance();
    }

    @Override
    public String toString() {
        return position.toString();
    }

    public void move() {
        this.position.increase();
    }
}
