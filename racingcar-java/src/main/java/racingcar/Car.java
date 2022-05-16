package racingcar;

public class Car {

    private final MoveStrategy moveStrategy;
    private final Name name;
    private final Position position;

    public Car(MoveStrategy moveStrategy, Name name, int positionNumber) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = new Position(positionNumber);
    }

    public Car(MoveStrategy moveStrategy, String nameString, int positionNumber) {
        this(moveStrategy, new Name(nameString), positionNumber);
    }

    public Car(MoveStrategy moveStrategy, String nameString) {
        this(moveStrategy, nameString, 1);
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

    public int getPosition() {
        return position.getDistance();
    }

    public String getName() {
        return name.getCarName();
    }
}
