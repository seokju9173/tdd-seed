package racingcar5;

public class Car {

    private String name;
    private Position position;

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name, int distance) {
        this(name, new Position(distance));
    }

    public Car(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getDistance();
    }
}
