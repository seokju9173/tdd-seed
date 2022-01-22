package racingcar.Car;

public class Car {
    private static final int ALLOW_DRIVE = 4;
    private static final int START_LINE = 0;
    private static final int DRIVE_CAR_AT_ONE_CYCLE = 1;

    private int position = START_LINE;

    public void drivingCar(int commandNumber) {
        if (commandNumber >= ALLOW_DRIVE) {
            this.position += DRIVE_CAR_AT_ONE_CYCLE;
        }
    }

    public int getPosition() {
        return position;
    }
}