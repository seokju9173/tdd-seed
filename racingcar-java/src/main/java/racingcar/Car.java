package racingcar;

public class Car {

    private final MoveStrategy moveStrategy;
    private final Name name;
    private final Position position;

    public Car(MoveStrategy moveStrategy, String string, int number) {
        this.moveStrategy = moveStrategy;
        this.name = new Name(string);
        this.position = new Position(number);
    }

    public Car(MoveStrategy moveStrategy, String string) {
        this.moveStrategy = moveStrategy;
        this.name = new Name(string);
        this.position = new Position();
    }

    public Car(MoveStrategy moveStrategy, Name name) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = new Position();
    }

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, "temp");
    }

    public int getPosition() {
        return position.getDistance();
    }

    public void move() {
        if(moveStrategy.isMove()) {
            position.increase();
        }
    }

    public String carString() {
        return position.positionString();
    }

    public String getName() {
        return name.getCarName();
    }
}
