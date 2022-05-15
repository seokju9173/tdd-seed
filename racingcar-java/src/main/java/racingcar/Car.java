package racingcar;

public class Car {

    private final MoveStrategy moveStrategy;
    private final Name name;
    private final Position position;

    public Car(MoveStrategy moveStrategy, Name name, int number) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = new Position(number);
    }

    public Car(MoveStrategy moveStrategy, String string, int number) {
        this(moveStrategy, new Name(string), number);
    }

    public Car(MoveStrategy moveStrategy, String string) {
        this(moveStrategy, string, 1);
    }

    public Car(MoveStrategy moveStrategy, Name name) {
        this(moveStrategy, name, 1);
    }

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, "temp");
    }

    public void move() {
        if(moveStrategy.isMove()) {
            position.increase();
        }
    }

    public String carPositionString() {
        return position.positionString();
    }

    public int getPosition() {
        return position.getDistance();
    }

    public String getName() {
        return name.getCarName();
    }
}
