package domain;

public class Car {

    private static final int CONDITION_MOVE = 4;

    private static final int DEFAULT_POSITION = 0;

    private static final int MAX_NAME_LENGTH = 5;

    private static final int MIN_RANDOM = 0;

    private static final int MAX_RANDOM = 10;

    private final String name;

    public int position = DEFAULT_POSITION;

    public Car (String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다");
        }
    }

    public void move(int randomInt) {
        validateInputRange(randomInt);
        if (randomInt >= CONDITION_MOVE) {
            position++;
        }
    }

    private void validateInputRange(int randomInt) {
        if (randomInt < MIN_RANDOM || randomInt >= MAX_RANDOM) {
            throw new IllegalArgumentException("0에서 9사이의 숫자여야 합니다");
        }
    }

    public int getPosition() {
        return position;
    }
    
    public String getName() {
        return name;
    }
}
