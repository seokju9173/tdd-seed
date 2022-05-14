package racingcar;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String string, int number) {
        this.name = new Name(string);
        this.position = new Position(number);
    }

    public Car(String string) {
        this(string, 1);
    }

    public Car() {
        this("temp");
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
