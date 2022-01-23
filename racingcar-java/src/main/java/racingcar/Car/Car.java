package racingcar.Car;

public class Car {
    private static final int ALLOW_DRIVE = 4;
    private static final int START_LINE = 0;
    private static final int DRIVE_CAR_AT_ONE_CYCLE = 1;
    private static final int LIMITED_NAME_LENGTH = 5;
    private static final int MAX_COMMAND_NUMBER = 10;
    private static final int MIN_COMMAND_NUMBER = 0;

    private final String carName;
    private int position = START_LINE;

    public Car(String carName) {
        if (carName.length() > LIMITED_NAME_LENGTH) {
            throw new RuntimeException("차량의 이름은 5자를 넘길 수 없습니다.");
        }
        this.carName = carName;
    }

    public void drivingCar(int commandNumber) {
        if (commandNumber >= MAX_COMMAND_NUMBER || commandNumber < MIN_COMMAND_NUMBER) {
            throw new RuntimeException("허용되지 않은 수치입니다.");
        }
        if (commandNumber >= ALLOW_DRIVE) {
            this.position += DRIVE_CAR_AT_ONE_CYCLE;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}