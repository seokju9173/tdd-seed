package mission03.domain;

public class RacingCar {

    private static final int INIT = 1;

    private int movedDistance; // 필드로 설정

    public RacingCar() {
        this.movedDistance = INIT;
    }

    public void moveCar() {
        this.movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
