package racingcar5;

public class Car {

    private final static int INITIAL_POSITION = 1;
    private final MoveStrategy moveStrategy;
    private final String name;
    private final Position position;

    public Car(MoveStrategy moveStrategy, String name, Position position) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = position;
    }

    public Car(MoveStrategy moveStrategy, String name, int distance) {
        this(moveStrategy, name, new Position(distance));
    }

    public Car(MoveStrategy moveStrategy, String name) {
        this(moveStrategy, name, INITIAL_POSITION);
    }

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, "temp", INITIAL_POSITION);
    }

    public void move() {
        if(moveStrategy.isMove()) {
            position.increase();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getDistance();
    }
}
