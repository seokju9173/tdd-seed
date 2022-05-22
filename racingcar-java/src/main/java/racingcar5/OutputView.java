package racingcar5;

import java.util.stream.IntStream;

public class OutputView {

    private final static String CAR_NAME_RESULT_DELIMITER = " : ";
    private final static char POSITION_CHARACTER = '-';

    public static void printAskingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public static void printCarResult(Car car) {
        StringBuilder stringBuilder = new StringBuilder(car.getName() + CAR_NAME_RESULT_DELIMITER);
        IntStream.range(0, car.getPosition())
                .forEach(i -> stringBuilder.append(POSITION_CHARACTER));
        System.out.println(stringBuilder);
    }
}
