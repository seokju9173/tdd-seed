package racingcar5;

public class Car {

    private MoveStrategy moveStrategy;
    private String name;
    private Position position;

    public Car(MoveStrategy moveStrategy, String name, Position position) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = position;
    }

    public Car(MoveStrategy moveStrategy, String name, int distance) {
        this(moveStrategy, name, new Position(distance));
    }

    public Car(MoveStrategy moveStrategy, String name) {
        this(moveStrategy, name, 1);
    }

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, "temp", 1);
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
